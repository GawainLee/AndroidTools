package com.petpetfairy.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.petpetfairy.R;
import com.petpetfairy.adapter.PetListAdapter;
import com.petpetfairy.model.PetDetail;
import com.petpetfairy.model.PetDetailImage;
import com.petpetfairy.model.PetListItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.petpetfairy.MainActivity.DETAIL;
import static com.petpetfairy.MainActivity.DETAIL_MESSAGE;
import static com.petpetfairy.MainActivity.HOME;


public class HomeFragment extends Fragment implements PetListAdapter.OnItemClickListener {

//    private TextView mTextTitle;
    public final static String EXTRA_URL = "imageUrl";
    public final static String EXTRA_CREATOR = "creatorName";
    public final static String EXTRA_LIKES = "likes";

    private RecyclerView mRecyclerView;
    private PetListAdapter mPetListAdapter;
    private ArrayList<PetListItem> mPetListItems;
    private RequestQueue mRequestQueue;
    private Context mContext;
    private HomeFragment mHomeFragment;

    public HomeFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mContext = container.getContext();
        mRecyclerView = root.findViewById(R.id.rv_images);
        mHomeFragment = this;
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mPetListItems = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(mContext);

        getPetList();

    }

    private void getPetList(){
//        String url = "https://pixabay.com/api/?key=21416733-030cfcaa6ccf5e3a4db3e4e8a&q=puppy&image_type=photo";
//        String url = "http://35.241.89.109/Petpetfairy-1-0.0.1-SNAPSHOT/getPetList";
        String url = "http://35.241.89.109/Petpetfairy-1-0.0.1-SNAPSHOT/getPetListNotAdopted";

        JsonArrayRequest mJsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Do something with response
                        // Process the JSON
                        try{
                            // Loop through the array elements
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                JSONObject petListJSONObject = response.getJSONObject(i);

                                PetListItem petListItem = new PetListItem(
                                        petListJSONObject.getInt("id"),
                                        petListJSONObject.getString("petName"),
                                        petListJSONObject.getString("petDetailImageLink"),
                                        petListJSONObject.getInt("petDetailLike"),
                                        petListJSONObject.getInt("petDetailImageWeight"),
                                        petListJSONObject.getInt("petDetailImageHeight")

                                );
//                                System.out.println(petListJSONObject.getString("petName"));
                                mPetListItems.add(petListItem);
                            }
                            mPetListAdapter = new PetListAdapter(mContext, mPetListItems,mHomeFragment);
                            mRecyclerView.setAdapter(mPetListAdapter);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred
                        error.printStackTrace();
                    }
                }
        );
        mRequestQueue.add(mJsonObjectRequest);

    }

    private void getPetDetailById(int petId){
        String url = "http://35.241.89.109/Petpetfairy-1-0.0.1-SNAPSHOT/getPetDetailById?id=" + petId;

        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    PetDetail petDetail = new PetDetail();
                    petDetail.setId(response.getInt("id"));
                    petDetail.setPetName(response.getString("petName"));
                    petDetail.setPetBreed(response.getString("petBreed"));
                    petDetail.setPetSex(response.getString("petSex"));
                    String petBrithday = (response.getString("petBrithday"));
                    petDetail.setPetAge(response.getString("petAge"));
                    petDetail.setPetCenter(response.getString("petCenter"));
                    petDetail.setPetIntake(response.getString("petIntake"));
                    petDetail.setPetMicrochip(response.getString("petMicrochip"));
                    petDetail.setPetNote(response.getString("petNote"));
                    petDetail.setPetDescription(response.getString("petDescription"));
                    String createDate = (response.getString("createDate"));
                    petDetail.setPetDetailLink(response.getString("petDetailLink"));
                    petDetail.setAgencyName(response.getString("agencyName"));
                    petDetail.setAgencyLink(response.getString("agencyLink"));
                    petDetail.setPetDetailLike(response.getInt("petDetailLike"));

                    List<PetDetailImage> petDetailImageList = new ArrayList<>();
                    JSONArray jsonArray = response.getJSONArray("petDetailImageList");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject petDetailImageJson = jsonArray.getJSONObject(i);
                        PetDetailImage petDetailImage = new PetDetailImage(
                                petDetailImageJson.getInt("idPetDetailImage"),
                                petDetailImageJson.getString("petDetailPetLink"),
                                petDetailImageJson.getString("petDetailImageLink"),
                                petDetailImageJson.getInt("petDetailImageWeight"),
                                petDetailImageJson.getInt("petDetailImageHeight")

                        );
                        petDetailImageList.add(petDetailImage);
                    }
                    petDetail.setPetDetailImageList(petDetailImageList);

                    FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();

                    if (mHomeFragment != null && !mHomeFragment.isHidden()) {
                        fragmentTransaction.hide(mHomeFragment);
                        fragmentTransaction.addToBackStack(HOME);
                    }


                    Bundle args = new Bundle();
                    args.putParcelable(DETAIL_MESSAGE, petDetail);
                    DetailFragment fragment = new DetailFragment();
                    fragment.setArguments(args);

                    fragmentTransaction.add(R.id.container_main, fragment, DETAIL).commit();
//                    getActivity().getFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.container_main, fragment, null)
//                            .addToBackStack(null)
//                            .commit();

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        );

        mRequestQueue.add(mJsonObjectRequest);
    }


    @Override
    public void onItemClick(int position) {
        PetListItem clickItem = mPetListItems.get(position);
        getPetDetailById(clickItem.getPetListItemId());
    }

//    public void onOpenDetail(String message) {
//        FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
//
//        if (mHomeFragment != null && !mHomeFragment.isHidden()) {
//            fragmentTransaction.hide(mHomeFragment);
//            fragmentTransaction.addToBackStack(HOME);
//        }
//
////        if (mDashboardFragment != null && !mDashboardFragment.isHidden()) {
////            fragmentTransaction.hide(mDashboardFragment).addToBackStack(DASHBOARD);
////        }
////        if (mNotificationsFragment != null && !mNotificationsFragment.isHidden()) {
////            fragmentTransaction.hide(mNotificationsFragment).addToBackStack(NOTIFICATIONS);
////        }
//
//        DetailFragment fragment = new DetailFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(DETAIL_MESSAGE, message);
//        fragment.setArguments(bundle);
//
//        fragmentTransaction.add(R.id.container_main, fragment, DETAIL).commit();
//    }
}