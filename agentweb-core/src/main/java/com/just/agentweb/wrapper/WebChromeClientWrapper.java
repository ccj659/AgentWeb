/*
 * Copyright (C)  Justson(https://github.com/Justson/AgentWeb)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.just.agentweb.wrapper;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;

import com.just.agentweb.LogUtils;

import java.lang.reflect.Method;

/**
 * @update WebChromeClientWrapper rename to WebChromeClientWrapper
 * @author cenxiaozhong
 * @since 1.0.0
 */
public class WebChromeClientWrapper extends WebChromeClient {
    private WebChromeClient mWrapper;

    protected WebChromeClient getDelegate() {
        return mWrapper;
    }

    public WebChromeClientWrapper(WebChromeClient webChromeClient) {
        this.mWrapper = webChromeClient;
    }

    void setDelegate(WebChromeClient delegate) {
        this.mWrapper = delegate;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        if (this.mWrapper != null) {
            this.mWrapper.onProgressChanged(view, newProgress);
            return;
        }

    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        if (this.mWrapper != null) {
            this.mWrapper.onReceivedTitle(view, title);
            return;
        }
        super.onReceivedTitle(view, title);
    }

    @Override
    public void onReceivedIcon(WebView view, Bitmap icon) {
        if (this.mWrapper != null) {
            this.mWrapper.onReceivedIcon(view, icon);
            return;
        }
        super.onReceivedIcon(view, icon);

    }

    @Override
    public void onReceivedTouchIconUrl(WebView view, String url,
                                       boolean precomposed) {
        if (this.mWrapper != null) {
            this.mWrapper.onReceivedTouchIconUrl(view, url, precomposed);
            return;
        }
        super.onReceivedTouchIconUrl(view, url, precomposed);
    }

    @Override
    public void onShowCustomView(View view, CustomViewCallback callback) {
        if (this.mWrapper != null) {
            this.mWrapper.onShowCustomView(view, callback);
            return;
        }
        super.onShowCustomView(view, callback);
    }


    @Override
    public void onShowCustomView(View view, int requestedOrientation,
                                 CustomViewCallback callback) {
        if (this.mWrapper != null) {
            this.mWrapper.onShowCustomView(view, requestedOrientation, callback);
            return;
        }
        super.onShowCustomView(view, requestedOrientation, callback);
    }


    @Override
    public void onHideCustomView() {
        if (this.mWrapper != null) {
            this.mWrapper.onHideCustomView();
            return;
        }
        super.onHideCustomView();
    }

    @Override
    public boolean onCreateWindow(WebView view, boolean isDialog,
                                  boolean isUserGesture, Message resultMsg) {
        if (this.mWrapper != null) {
            return this.mWrapper.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
        }
        return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
    }

    @Override
    public void onRequestFocus(WebView view) {
        if (this.mWrapper != null) {
            this.mWrapper.onRequestFocus(view);
            return;
        }
        super.onRequestFocus(view);
    }

    @Override
    public void onCloseWindow(WebView window) {
        if (this.mWrapper != null) {
            this.mWrapper.onCloseWindow(window);
            return;
        }
        super.onCloseWindow(window);
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message,
                             JsResult result) {
        if (this.mWrapper != null) {
            return this.mWrapper.onJsAlert(view, url, message, result);
        }
        return super.onJsAlert(view, url, message, result);
    }

    @Override
    public boolean onJsConfirm(WebView view, String url, String message,
                               JsResult result) {
        if (this.mWrapper != null) {
            return this.mWrapper.onJsConfirm(view, url, message, result);
        }
        return super.onJsConfirm(view, url, message, result);
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message,
                              String defaultValue, JsPromptResult result) {
        if (this.mWrapper != null) {
            return this.mWrapper.onJsPrompt(view, url, message, defaultValue, result);
        }
        return super.onJsPrompt(view, url, message, defaultValue, result);
    }

    @Override
    public boolean onJsBeforeUnload(WebView view, String url, String message,
                                    JsResult result) {
        if (this.mWrapper != null) {
            return this.mWrapper.onJsBeforeUnload(view, url, message, result);
        }
        return super.onJsBeforeUnload(view, url, message, result);
    }

    @Override
    @Deprecated
    public void onExceededDatabaseQuota(String url, String databaseIdentifier,
                                        long quota, long estimatedDatabaseSize, long totalQuota,
                                        WebStorage.QuotaUpdater quotaUpdater) {
        // This default implementation passes the current quota back to WebCore.
        // WebCore will interpret this that new quota was declined.
        if (this.mWrapper != null) {
            this.mWrapper.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
            return;
        }
        super.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);

    }

    @Override
    @Deprecated
    public void onReachedMaxAppCacheSize(long requiredStorage, long quota,
                                         WebStorage.QuotaUpdater quotaUpdater) {
        if (this.mWrapper != null) {
            this.mWrapper.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater);
            return;
        }
        super.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater);
    }

    @Override
    public void onGeolocationPermissionsShowPrompt(String origin,
                                                   GeolocationPermissions.Callback callback) {
        if (this.mWrapper != null) {
            this.mWrapper.onGeolocationPermissionsShowPrompt(origin, callback);
            return;
        }
        super.onGeolocationPermissionsShowPrompt(origin, callback);

    }

    /**
     * notify the host application that a request for Geolocation permissions,
     * made with a previous call to
     * {@link #onGeolocationPermissionsShowPrompt(String, GeolocationPermissions.Callback) onGeolocationPermissionsShowPrompt()}
     * has been canceled. Any related UI should therefore be hidden.
     */
    @Override
    public void onGeolocationPermissionsHidePrompt() {

        if (this.mWrapper != null) {
            this.mWrapper.onGeolocationPermissionsHidePrompt();
            return;
        }

        super.onGeolocationPermissionsHidePrompt();
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onPermissionRequest(PermissionRequest request) {
//        request.deny();
        if (this.mWrapper != null) {
            this.mWrapper.onPermissionRequest(request);
            return;
        }
        super.onPermissionRequest(request);
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onPermissionRequestCanceled(PermissionRequest request) {

        if (this.mWrapper != null) {
            this.mWrapper.onPermissionRequestCanceled(request);
            return;
        }
        super.onPermissionRequestCanceled(request);
    }

    @Override
    public boolean onJsTimeout() {
        if (this.mWrapper != null) {
            return this.mWrapper.onJsTimeout();
        }
        return super.onJsTimeout();
    }

    @Override
    @Deprecated
    public void onConsoleMessage(String message, int lineNumber, String sourceID) {
        if (this.mWrapper != null) {
            this.mWrapper.onConsoleMessage(message, lineNumber, sourceID);
            return;
        }
        super.onConsoleMessage(message, lineNumber, sourceID);
    }

    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        /*onConsoleMessage(consoleMessage.message(), consoleMessage.lineNumber(),
                consoleMessage.sourceId());*/

        if (this.mWrapper != null) {
            return this.mWrapper.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override
    public Bitmap getDefaultVideoPoster() {
        if (this.mWrapper != null) {
            return this.mWrapper.getDefaultVideoPoster();
        }
        return super.getDefaultVideoPoster();
    }

    @Override
    public View getVideoLoadingProgressView() {
        if (this.mWrapper != null) {
            return this.mWrapper.getVideoLoadingProgressView();
        }
        return super.getVideoLoadingProgressView();
    }

    @Override
    public void getVisitedHistory(ValueCallback<String[]> callback) {
        if (this.mWrapper != null) {
            this.mWrapper.getVisitedHistory(callback);
            return;
        }
        super.getVisitedHistory(callback);
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback,
                                     FileChooserParams fileChooserParams) {
        if (this.mWrapper != null) {
            return this.mWrapper.onShowFileChooser(webView, filePathCallback, fileChooserParams);
        }
        return super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
    }


    // Android  >= 4.1
    public void openFileChooser(ValueCallback<Uri> uploadFile, String acceptType, String capture) {
        commonRefect(this.mWrapper, "openFileChooser", new Object[]{uploadFile, acceptType, capture}, ValueCallback.class, String.class, String.class);
    }

    //  Android < 3.0
    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        commonRefect(this.mWrapper, "openFileChooser", new Object[]{valueCallback}, ValueCallback.class);
    }

    //  Android  >= 3.0
    public void openFileChooser(ValueCallback valueCallback, String acceptType) {
        commonRefect(this.mWrapper, "openFileChooser", new Object[]{valueCallback, acceptType}, ValueCallback.class, String.class);
    }


    private void commonRefect(WebChromeClient o, String mothed, Object[] os, Class... clazzs) {
        try {
            if (o == null) {
                return;
            }
            Class<?> clazz = o.getClass();
            Method mMethod = clazz.getMethod(mothed, clazzs);
            mMethod.invoke(o, os);
        } catch (Exception ignore) {
            if (LogUtils.isDebug()) {
                ignore.printStackTrace();
            }
        }

    }


}
