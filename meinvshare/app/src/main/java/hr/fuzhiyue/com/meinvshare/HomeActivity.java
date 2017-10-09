package hr.fuzhiyue.com.meinvshare;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import hr.fuzhiyue.com.meinvshare.http.GirlRetrofitHelper;
import hr.fuzhiyue.com.meinvshare.http.GirlService;
import hr.fuzhiyue.com.meinvshare.model.GirlResult;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.test_recycler_view);
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        final List<GirlResult.GirlEntity> list = new ArrayList<GirlResult.GirlEntity>();
        final GirlAdapter girlAdapter = new GirlAdapter(HomeActivity.this, list);
        recyclerView.setAdapter(girlAdapter);

        GirlRetrofitHelper.getRetrofit()
                .create(GirlService.class)
                .getGirls("福利",10,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GirlResult>() {
                    @Override
                    public void onCompleted() {
                        Log.d("fuzhiyuehello", "done");
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d("fuzhiyuehello_error", e.getMessage());
                    }

                    @Override
                    public void onNext(GirlResult girlResult) {
                        list.addAll(girlResult.getResults());
                        Log.d("fuzhiyuehello", ""+list.size());
                        girlAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
