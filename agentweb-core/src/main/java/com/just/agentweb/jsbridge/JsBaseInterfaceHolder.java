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

package com.just.agentweb.jsbridge;

import android.os.Build;
import android.webkit.JavascriptInterface;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.jsbridge.dao.JsInterfaceHolder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * js 安全校验
 * 两种方法混合使用，即Android 4.4以下使用方法1，Android 4.4以上方法2
 */
public abstract class JsBaseInterfaceHolder implements JsInterfaceHolder {

    private AgentWeb.SecurityType mSecurityType;

    protected JsBaseInterfaceHolder(AgentWeb.SecurityType securityType) {
        this.mSecurityType = securityType;
    }

    /**
     * 判断是否有JavascriptInterface 注解,避免被注入攻击
     * @param v
     * @return
     */
    @Override
    public boolean checkObject(Object v) {
        //// 因为该方法在 Android 4.4 版本才可使用，所以使用时需进行版本判断
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2){
            return true;
        }
        if (AgentWebConfig.WEBVIEW_TYPE == AgentWebConfig.WEBVIEW_AGENTWEB_SAFE_TYPE){
            return true;
        }
        boolean tag = false;
        Class clazz = v.getClass();

        Method[] mMethods = clazz.getMethods();

        for (Method mMethod : mMethods) {

            Annotation[] mAnnotations = mMethod.getAnnotations();

            for (Annotation mAnnotation : mAnnotations) {

                if (mAnnotation instanceof JavascriptInterface) {
                    tag = true;
                    break;
                }

            }
            if (tag){
                break;
            }
        }

        return tag;
    }

    protected boolean checkSecurity() {
        return mSecurityType != AgentWeb.SecurityType.STRICT_CHECK
                ? true : AgentWebConfig.WEBVIEW_TYPE == AgentWebConfig.WEBVIEW_AGENTWEB_SAFE_TYPE
                ? true : Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR1;
    }


}
