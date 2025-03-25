/*
 * ------------------------------------------------------------------------
 * Max chat Bot API
 * ------------------------------------------------------------------------
 * Copyright (C) 2025 COMMUNICATION PLATFORM LLC
 * ------------------------------------------------------------------------
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
 * ------------------------------------------------------------------------
 */

package ru.max.botapi.queries;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class QueryParam<T> {
    private final String name;
    private T value;
    private boolean isRequired;

    public QueryParam(@NotNull String name, @NotNull MaxQuery<?> holder) {
        this(name, null, holder);
    }

    public QueryParam(@NotNull String name, @Nullable T defaultValue, @NotNull MaxQuery<?> holder) {
        this.name = name;
        this.value = defaultValue;
        holder.addParam(this);
    }

    @NotNull
    public String getName() {
        return name;
    }

    @Nullable
    public T getValue() {
        return value;
    }

    public void setValue(@Nullable T value) {
        this.value = value;
    }

    @NotNull
    public QueryParam<T> required() {
        this.isRequired = true;
        return this;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public String format() {
        return String.valueOf(value);
    }
}
