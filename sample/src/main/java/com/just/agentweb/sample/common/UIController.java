package com.just.agentweb.sample.common;

import android.app.Activity;
import android.os.Handler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;

import com.just.agentweb.view.webparent.WebParentLayout;
import com.just.agentweb.web.controller.UIControllerDao;

/**
 * Created by cenxiaozhong on 2017/12/23.
 */

/**
 * 如果你需要修改某一个AgentWeb 内部的某一个弹窗 ，请看下面的例子
 * 注意写法一定要参照 DefaultUIControllerImp 的写法 ，因为UI自由定制，但是回调的方式是固定的，并且一定要回调。
 */
public class UIController extends UIControllerDao {

    private Activity mActivity;
    public UIController(Activity activity){
        this.mActivity=activity;
    }

    @Override
    protected void bindSupportWebParent(WebParentLayout webParentLayout, Activity activity) {

    }

    /**
     * WebChromeClient#onJsAlert
     *
     * @param view
     * @param url
     * @param message
     */
    @Override
    public void onJsAlert(WebView view, String url, String message) {

    }

    /**
     * 咨询用户是否前往其他页面
     *
     * @param view
     * @param url
     * @param callback
     */
    @Override
    public void onOpenPagePrompt(WebView view, String url, Handler.Callback callback) {

    }

    /**
     * WebChromeClient#onJsConfirm
     *
     * @param view
     * @param url
     * @param message
     * @param jsResult
     */
    @Override
    public void onJsConfirm(WebView view, String url, String message, JsResult jsResult) {

    }

    @Override
    public void onSelectItemsPrompt(WebView view, String url, String[] ways, Handler.Callback callback) {

    }

    /**
     * 强制下载弹窗
     *
     * @param url      当前下载地址。
     * @param callback 用户操作回调回调
     */
    @Override
    public void onForceDownloadAlert(String url, Handler.Callback callback) {

    }

    /**
     * WebChromeClient#onJsPrompt
     *
     * @param view
     * @param url
     * @param message
     * @param defaultValue
     * @param jsPromptResult
     */
    @Override
    public void onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult jsPromptResult) {

    }

    /**
     * 显示错误页
     *
     * @param view
     * @param errorCode
     * @param description
     * @param failingUrl
     */
    @Override
    public void onMainFrameError(WebView view, int errorCode, String description, String failingUrl) {

    }

    /**
     * 隐藏错误页
     */
    @Override
    public void onShowMainFrame() {

    }

    /**
     * 弹窗正在加载...
     *
     * @param msg
     */
    @Override
    public void onLoading(String msg) {

    }

    /**
     * 正在加载弹窗取消
     */
    @Override
    public void onCancelLoading() {

    }

    /**
     * @param message 消息
     * @param intent  说明message的来源，意图
     */
    @Override
    public void onShowMessage(String message, String intent) {

    }

    /**
     * 当权限被拒回调该方法
     *
     * @param permissions
     * @param permissionType
     * @param action
     */
    @Override
    public void onPermissionsDeny(String[] permissions, String permissionType, String action) {

    }
}
