package com.hfad.beeradviser11;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class FindBeerActivity extends Activity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view){
        //텍스트뷰의 레퍼런스를 얻음
        TextView brands = (TextView)findViewById(R.id.brands);
        //스피너의 레퍼런스를 얻음
        Spinner color = (Spinner)findViewById(R.id.color);
        //스피너에서 선택한 항목을 얻음
        String beerType = String.valueOf(color.getSelectedItem());
        //BeerExpert 클래스를 이용해서 추천 맥주 목록을 얻음
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand :brandsList){
            brandsFormatted.append(brand).append("\n");
        }
        //맥주 목록 표시
        brands.setText(brandsFormatted);
    }

}
