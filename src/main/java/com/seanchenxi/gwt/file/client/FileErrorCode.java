/*
 * Copyright 2013 Xi CHEN
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.seanchenxi.gwt.file.client;

/**
 * User: Xi
 */
public enum FileErrorCode {

    /**
     * The file operation was aborted, probably due to a call to the <code>FileReader</code> <code>abort()</code>&nbsp),method.
     */

    ABORT_ERR(3),

    /**
     * The file data cannot be accurately represented in a data URL.
     */

    ENCODING_ERR(5),

    INVALID_MODIFICATION_ERR(9),

    INVALID_STATE_ERR(7),

    /**
     * File not found.
     */

    NOT_FOUND_ERR(1),

    /**
     * File could not be read.
     */

    NOT_READABLE_ERR(4),

    NO_MODIFICATION_ALLOWED_ERR(6),

    PATH_EXISTS_ERR(12),

    QUOTA_EXCEEDED_ERR(10),

    /**
     * The file could not be accessed for security reasons.
     */

    SECURITY_ERR(2),

    SYNTAX_ERR(8),

    TYPE_MISMATCH_ERR(11);


    private final int value;

    private FileErrorCode(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static FileErrorCode parseValue(int value){
        for(FileErrorCode frs : values()){
            if(frs.value == value){
                return frs;
            }
        }
        return null;
    }
}
