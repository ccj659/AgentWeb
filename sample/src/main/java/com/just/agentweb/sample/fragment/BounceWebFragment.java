package com.just.agentweb.sample.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.web.DefaultWebClient;
import com.just.agentweb.view.webparent.IWebLayout;
import com.just.agentweb.sample.R;
import com.just.agentweb.sample.widget.WebLayout;

/**
 * Created by cenxiaozhong on 2017/7/1.
 *  source code  https://github.com/Justson/AgentWeb
 */

public class BounceWebFragment extends AgentWebFragment {

    public static BounceWebFragment getInstance(Bundle bundle){

        BounceWebFragment mBounceWebFragment =new BounceWebFragment();
        if(mBounceWebFragment !=null)
            mBounceWebFragment.setArguments(bundle);

        return mBounceWebFragment;
    }


    @Override
    public String getUrl() {
        return super.getUrl();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mAgentWeb = AgentWeb.with(this)//
                .setAgentWebParent((ViewGroup) view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))//
                .useDefaultIndicator(-1, 2)//
                .setAgentWebWebSettings(getSettings())//
                .setWebViewClient(mWebViewClient)
                .setWebChromeClient(mWebChromeClient)
                .setWebLayout(getWebLayout())
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
//                .setDownloadListener(mDownloadListener)  4.0.0 删除该API
                .interceptUnkownUrl()
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)
                .setMainFrameErrorView(R.layout.agentweb_error_page,-1)
                .createAgentWeb()//
                .ready()//
                .go(getUrl());



        addBGChild((FrameLayout) mAgentWeb.getWebCreator().getWebParentLayout()); // 得到 AgentWeb 最底层的控件
        initView(view);


    }

    protected IWebLayout getWebLayout() {
        return new WebLayout(getActivity());
    }


    protected void addBGChild(FrameLayout frameLayout) {

        TextView mTextView=new TextView(frameLayout.getContext());
        mTextView.setText("技术由 AgentWeb 提供");
        mTextView.setTextSize(16);
        mTextView.setTextColor(Color.parseColor("#727779"));
        frameLayout.setBackgroundColor(Color.parseColor("#272b2d"));
        FrameLayout.LayoutParams mFlp=new FrameLayout.LayoutParams(-2,-2);
        mFlp.gravity= Gravity.CENTER_HORIZONTAL;
        final float scale = frameLayout.getContext().getResources().getDisplayMetrics().density;
        mFlp.topMargin= (int) (15 * scale + 0.5f);
        frameLayout.addView(mTextView,0,mFlp);
    }


}
