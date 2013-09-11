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

package com.seanchenxi.gwt.bootstrap.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * User: Xi
 */
public interface Bootstrap extends ClientBundle {

    public interface CSS extends CssResource{
        final static String DEFAULT_CSS = "com/seanchenxi/gwt/bootstrap/client/css/bootstrap.css";

        String btn();

        @ClassName("btn-warning")
        String btnWarning();

        @ClassName("btn-primary")
        String btnPrimary();

        @ClassName("btn-danger")
        String btnDanger();

        @ClassName("btn-success")
        String btnSuccess();

        @ClassName("btn-info")
        String btnInfo();

        @ClassName("btn-inverse")
        String btnInverse();

        String active();

        String disabled();

        @ClassName("uneditable-input")
        String uneditableInput();

        @ClassName("uneditable-textarea")
        String uneditableTextArea();

        @ClassName("btn-group")
        String btnGroup();

        @ClassName("dropdown-menu")
        String dropdownMenu();

        @ClassName("dropdown-toggle")
        String dropdownToggle() ;

        @ClassName("btn-mini")
        String btnMini();

        @ClassName("btn-large")
        String btnLarge();

        @ClassName("btn-small")
        String btnSmall();

        String large();

        String open();

        @ClassName("dropdown-submenu")
        String dropdownSubmenu();

        @ClassName("btn-toolbar")
        String btnToolbar();

        String caret();

        @ClassName("pull-left")
        String pullLeft();

        String dropup();

        @ClassName("dropdown-backdrop")
        String dropdownBackdrop();

        @ClassName("navbar-fixed-bottom")
        String navbarFixedBottom();

        @ClassName("nav-header")
        String navHeader();

        String popover();

        String divider();

        String dropdown();

        @ClassName("pull-right")
        String pullRight();

        String label();

        @ClassName("label-important")
        String labelImportant();

        @ClassName("badge-inverse")
        String badgeInverse();

        @ClassName("badge-warning")
        String badgeWarning();

        @ClassName("label-inverse")
        String labelInverse();

        @ClassName("label-warning")
        String labelWarning();

        @ClassName("label-info")
        String labelInfo();

        @ClassName("badge-info")
        String badgeInfo();

        @ClassName("label-success")
        String labelSuccess();

        @ClassName("badge-important")
        String badgeImportant();

        String badge();

        @ClassName("badge-success")
        String badgeSuccess();
    }

    @Source(CSS.DEFAULT_CSS)
    CSS style();
}
