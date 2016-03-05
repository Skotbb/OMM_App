package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.scott.ohemem.R;
import com.example.scott.ohemem.TechniqueListFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 */
public class CategoryFragment extends Fragment implements Button.OnClickListener {
    private static final String DEBUG_MESS = "CatFragment";

    Button m_counterStrainBtn;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_category, container, false);

        m_counterStrainBtn = (Button) view.findViewById(R.id.btn_counterstrain);
        m_counterStrainBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_counterstrain: {
                fragmentChange(R.id.btn_counterstrain);
                Log.d(DEBUG_MESS, "Counterstrain Pressed");
            }
            case R.id.btn_hvla: {

            }
            case R.id.btn_muscle_energy: {

            }
            case R.id.btn_blt: {

            }
            case R.id.btn_fpr: {

            }
            case R.id.btn_soft_tissue: {

            }
            case R.id.btn_cranial_sac: {

            }
            case R.id.btn_articulatory: {

            }
        }
    }

    private void fragmentChange(int btnID) {
        TechniqueListFragment techList = (TechniqueListFragment)
                getActivity().getSupportFragmentManager().findFragmentById(R.id.list_fragment);

        if (techList != null && !techList.isVisible()) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            techList.setContentFor(btnID);
        } else {
            // Otherwise, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            TechniqueListFragment newFragment = new TechniqueListFragment();
            Bundle args = new Bundle();
            args.putInt(TechniqueListFragment.ARG_BTN_PRESSED, btnID);
            newFragment.setArguments(args);

            android.support.v4.app.FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.activity_main, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }


    }

}