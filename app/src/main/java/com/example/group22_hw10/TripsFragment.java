// Group22_HW10
// TripsFragment.java
// Ken Stanley & Stephanie Karp

package com.example.group22_hw10;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.group22_hw10.databinding.FragmentLoginBinding;
import com.example.group22_hw10.databinding.FragmentTripsBinding;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class TripsFragment extends Fragment {
    FragmentTripsBinding binding;

    private static final String ARG_USER = "user";

    private FirebaseUser firebaseUser;
    private final FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private FirestoreRecyclerAdapter<Trip, TripHolder> adapter;

    public TripsFragment() {
        // Required empty public constructor
    }

    public static TripsFragment newInstance(FirebaseUser user) {
        TripsFragment fragment = new TripsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            firebaseUser = getArguments().getParcelable(ARG_USER);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTripsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireActivity().setTitle(R.string.trips_title);
    }

    private class TripHolder extends RecyclerView.ViewHolder {

        public TripHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}