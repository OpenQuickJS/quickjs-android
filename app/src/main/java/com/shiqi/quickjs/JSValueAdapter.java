/*
 * Copyright 2019 Hippo Seven
 * Copyright 2023-Present Shiqi Mei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shiqi.quickjs;

import androidx.annotation.Nullable;

import java.lang.reflect.Type;

class JSValueAdapter {

  static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() {

    @Nullable
    @Override
    public TypeAdapter<?> create(QuickJS quickJS, Type type) {
      if (type == JSValue.class) return JS_VALUE_TYPE_ADAPTER;
      return null;
    }
  };

  private static final TypeAdapter<JSValue> JS_VALUE_TYPE_ADAPTER = new TypeAdapter<JSValue>() {
    @Override
    public JSValue toJSValue(JSContext context, JSValue value) {
      if (value == null) throw new NullPointerException("value == null");
      return value;
    }

    @Override
    public JSValue fromJSValue(JSContext context, JSValue value) {
      return value;
    }
  };
}
