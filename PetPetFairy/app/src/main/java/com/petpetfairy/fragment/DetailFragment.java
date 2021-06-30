package com.petpetfairy.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.petpetfairy.MainActivity;
import com.petpetfairy.R;
import com.petpetfairy.adapter.ViewPagerAdapter;
import com.petpetfairy.model.PetDetail;
import com.petpetfairy.model.PetDetailImage;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import static com.petpetfairy.MainActivity.DETAIL_MESSAGE;


/**
 * Created by Wayne Chen on 2018/5/4.
 */
public class DetailFragment extends Fragment {

    private TextView mTextViewPetName;
    private TextView mTextViewPetDetail;
//    private ImageView mImageViewPetImage;
    private TextView mTextViewPetDetailLink;

    private ViewPager mViewPager;
    private DotsIndicator mDotsIndicator;

    public DetailFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detail, container, false);
//        mImageViewPetImage = (ImageView) root.findViewById(R.id.image_view_detail);
        mTextViewPetName = (TextView) root.findViewById(R.id.text_view_creator_detail);
        mTextViewPetDetail = (TextView) root.findViewById(R.id.text_view_likes_detail);
        mTextViewPetDetailLink = (TextView) root.findViewById(R.id.text_view_pet_detail_link);
        mViewPager = root.findViewById(R.id.viewpager_detail);
        mDotsIndicator = (DotsIndicator) root.findViewById(R.id.dots_indicator);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("OnViewCreated");
        ((MainActivity) getActivity()).openDetail();
        if (getArguments() != null) {
            Bundle bundle = this.getArguments();
            if (bundle != null) {
                PetDetail petDetail  = bundle.getParcelable(DETAIL_MESSAGE);
                List<PetDetailImage> petDetailImages = petDetail.getPetDetailImageList();
//                String petDetailImageLinkString = petDetailImages.get(0).getPetDetailImageLink();
//                Picasso.get().load(petDetailImageLinkString).fit().centerInside().into(mImageViewPetImage);
                mTextViewPetName.setText(petDetail.getPetName());
                String petDetailString = "";
                String nullString = "null";
                if(petDetail.getAgencyName() !=null && petDetail.getAgencyName().length() > 0 && !nullString.equals(petDetail.getAgencyName())){
                    petDetailString += "Agency Name :\n" + petDetail.getAgencyName() + "\n";
                }
                if(petDetail.getPetCenter() !=null && petDetail.getPetCenter().length() > 0 && !nullString.equals(petDetail.getPetCenter())){
                    petDetailString += "Center :\n" + petDetail.getPetCenter() + "\n" ;
                }
                if(petDetail.getPetIntake() !=null && petDetail.getPetIntake().length() > 0 && !nullString.equals(petDetail.getPetIntake())){
                    petDetailString += "Intake :\n" + petDetail.getPetIntake() + "\n" ;
                }
                if(petDetail.getPetMicrochip() !=null && petDetail.getPetMicrochip().length() > 0 && !nullString.equals(petDetail.getPetMicrochip())){
                    petDetailString += "Microchip :\n" + petDetail.getPetMicrochip() + "\n";
                }
                if(petDetail.getPetBreed() !=null && petDetail.getPetBreed().length() > 0 && !nullString.equals(petDetail.getPetBreed())){
                    petDetailString += "Breed :\n" + petDetail.getPetBreed() + "\n";
                }
                if(petDetail.getPetNote() !=null && petDetail.getPetNote().length() > 0 && !nullString.equals(petDetail.getPetNote())){
                    petDetailString += "Note :\n" + petDetail.getPetNote() + "\n";
                }
                if(petDetail.getPetDescription() !=null && petDetail.getPetDescription().length() > 0 && !nullString.equals(petDetail.getPetDescription())){
                    petDetailString += "Description :\n" + petDetail.getPetDescription() + "\n";
                }
//                if(petDetail.getPetDetailLink() !=null && petDetail.getPetDetailLink().length() > 0 && !nullString.equals(petDetail.getPetDetailLink())){
//                    petDetailString += "Link :\n" + petDetail.getPetDetailLink() + "\n\n";
//                }
//                ""Agency Name :\n" + petDetail.getAgencyName() + "\n" +
//                        "Center :\n" + petDetail.getPetCenter() + "\n" +
//                        "Intake :\n" + petDetail.getPetIntake() + "\n" +
//                        "Microchip :\n" + petDetail.getPetMicrochip() + "\n" +
//                        "Breed :\n" + petDetail.getPetBreed() + "\n" +
//                        "Note :\n" + petDetail.getPetNote() + "\n" +
//                        "Description :\n" + petDetail.getPetDescription() + "\n" +
//                        "Link :\n" + petDetail.getPetDetailLink() + "\n\n";
                mTextViewPetDetail.setText(petDetailString);
                if(petDetail.getPetDetailLink() !=null && petDetail.getPetDetailLink().length() > 0 && !nullString.equals(petDetail.getPetDetailLink())){
//                    mTextViewPetDetailLink.setText("Link :\n" + petDetail.getPetDetailLink() + "\n\n");
                    mTextViewPetDetailLink.setText(petDetail.getPetDetailLink());
                    mTextViewPetDetailLink.setMovementMethod(LinkMovementMethod.getInstance());
                }

                //*************
                ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity(), petDetailImages);
                mViewPager.setAdapter(adapter);
                mDotsIndicator.setViewPager(mViewPager);
            }
        }
    }

//    @Override
//    public void onPause() {
////        System.out.println("OnPause");
////        getActivity().getFragmentManager().beginTransaction().remove(this).commit();
//        super.onPause();
//    }

//    @Override
//    public void onStop() {
////        System.out.println("OnStop");
////        getActivity().getFragmentManager().beginTransaction().remove(this).commit();
//        super.onStop();
//    }
}
