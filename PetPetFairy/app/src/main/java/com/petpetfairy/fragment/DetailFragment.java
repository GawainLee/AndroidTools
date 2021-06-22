package com.petpetfairy.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.petpetfairy.MainActivity;
import com.petpetfairy.R;
import com.petpetfairy.model.PetDetail;
import com.petpetfairy.model.PetDetailImage;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.Nullable;

import static com.petpetfairy.MainActivity.DETAIL_MESSAGE;


/**
 * Created by Wayne Chen on 2018/5/4.
 */
public class DetailFragment extends Fragment {

    private TextView mTextViewPetName;
    private TextView mTextViewPetDetail;
    private ImageView mImageViewPetImage;

    public DetailFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detail, container, false);
        mImageViewPetImage = (ImageView) root.findViewById(R.id.image_view_detail);
        mTextViewPetName = (TextView) root.findViewById(R.id.text_view_creator_detail);
        mTextViewPetDetail = (TextView) root.findViewById(R.id.text_view_likes_detail);
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
                String petDetailImageLinkString = petDetailImages.get(0).getPetDetailImageLink();
                Picasso.get().load(petDetailImageLinkString).fit().centerInside().into(mImageViewPetImage);
                mTextViewPetName.setText(petDetail.getPetName());
                String petDetailString = "Agency Name :\n" + petDetail.getAgencyName() + "\n" +
                        "Center :\n" + petDetail.getPetCenter() + "\n" +
                        "Intake :\n" + petDetail.getPetIntake() + "\n" +
                        "Microchip :\n" + petDetail.getPetMicrochip() + "\n" +
                        "Breed :\n" + petDetail.getPetBreed() + "\n" +
                        "Note :\n" + petDetail.getPetNote() + "\n" +
                        "Description :\n" + petDetail.getPetDescription() + "\n" +
                        "Link :\n" + petDetail.getPetDetailLink() + "\n\n"
                        ;
                mTextViewPetDetail.setText(petDetailString);
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
