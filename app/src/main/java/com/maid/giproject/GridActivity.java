package com.maid.giproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.maid.giproject.R;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private List<Sport> sportsList;
    private TextView favoritesTextView,tv_favorite;
    private Button showFavoritesButton;
    private GridView gridView;
    private SharedPreferences sharedPreferences;
    private SearchView searchView;
    private SportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);

        tv_favorite = findViewById(R.id.tv_favorites);
        gridView = findViewById(R.id.grid_view);
        favoritesTextView = findViewById(R.id.tv_favorites);
        showFavoritesButton = findViewById(R.id.btn_show_favorites);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);


        sportsList = new ArrayList<>();
        sportsList.add(new Sport("Football", R.drawable.football));
        sportsList.add(new Sport("NBA", R.drawable.nba));
        sportsList.add(new Sport("Tennis", R.drawable.tennis));
        sportsList.add(new Sport("Cricket", R.drawable.cricket));
        sportsList.add(new Sport("NFL", R.drawable.nfl));
        sportsList.add(new Sport("NHL", R.drawable.nhl));
        sportsList.add(new Sport("EPL", R.drawable.epl));
        sportsList.add(new Sport("Masters Golf", R.drawable.golf));
        sportsList.add(new Sport("F1", R.drawable.formula));

        adapter = new SportAdapter(this, sportsList);
        gridView.setAdapter(adapter);

        // Add more sports as needed

        final SportAdapter adapter = new SportAdapter(this, sportsList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sport selectedSport = sportsList.get(position);
                Button button = view.findViewById(R.id.btn_sport);
                if (selectedSport.isFavorite()) {
                    selectedSport.setFavorite(false);
                    button.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    if (countFavorites(sportsList) < 3) {
                        selectedSport.setFavorite(true);
                        button.setBackgroundColor(ContextCompat.getColor(GridActivity.this, R.color.colorAccent));
                    } else {
                        Toast.makeText(GridActivity.this, "You can only select up to three favorites.", Toast.LENGTH_SHORT).show();
                    }
                }
                saveFavorites(); // Save favorites after each selection
            }
        });

        showFavoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFavorites();
            }
        });

        loadFavorites(); // Load favorites when the app starts
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // Handle search query submission (if needed)
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // Filter the data based on the search query
        adapter.getFilter().filter(newText);
        return true;
    }




    private int countFavorites(List<Sport> sportsList) {
        int count = 0;
        for (Sport sport : sportsList) {
            if (sport.isFavorite()) {
                count++;
            }
        }
        return count;
    }

    private void showFavorites() {
        StringBuilder favoritesBuilder = new StringBuilder();
        for (Sport sport : sportsList) {
            if (sport.isFavorite()) {
                if (favoritesBuilder.length() > 0) {
                    favoritesBuilder.append(", ");
                }
                favoritesBuilder.append(sport.getName());
            }
        }

        String favoritesText = favoritesBuilder.toString();
        favoritesTextView.setText(favoritesText);
    }

    private void saveFavorites() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < sportsList.size(); i++) {
            Sport sport = sportsList.get(i);
            editor.putBoolean("favorite_" + i, sport.isFavorite());
        }
        editor.apply();
    }

    private void loadFavorites() {
        gridView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // Remove the listener to prevent multiple calls
                gridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                // Iterate through the sportsList and set the favorites
                for (int i = 0; i < sportsList.size(); i++) {
                    Sport sport = sportsList.get(i);
                    boolean isFavorite = sharedPreferences.getBoolean("favorite_" + i, false);
                    sport.setFavorite(isFavorite);
                    if (isFavorite) {
                        // Set background color for the favorite sports
                        final int tempIndex = i; // Create a final copy of i
                        gridView.post(new Runnable() {
                            @Override
                            public void run() {
                                View view = gridView.getChildAt(tempIndex);
                                if (view != null) {
                                    Button button = view.findViewById(R.id.btn_sport);
                                    button.setBackgroundColor(ContextCompat.getColor(GridActivity.this, R.color.colorAccent));
                                }
                            }
                        });
                    }
                }
            }
        });
    }


    public void skip(View v){
        Intent intent = new Intent(GridActivity.this,MainActivity.class);
        intent.putExtra("mydata",tv_favorite.getText().toString());
        startActivity(intent);

    }



}
