/*
 * Copyright 2011 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.terminal.gwt.client.ui.customcomponent;

import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.terminal.gwt.client.ComponentConnector;
import com.vaadin.terminal.gwt.client.ConnectorHierarchyChangeEvent;
import com.vaadin.terminal.gwt.client.ui.AbstractComponentContainerConnector;
import com.vaadin.ui.CustomComponent;

@Connect(value = CustomComponent.class, loadStyle = LoadStyle.EAGER)
public class CustomComponentConnector extends
        AbstractComponentContainerConnector {

    @Override
    public VCustomComponent getWidget() {
        return (VCustomComponent) super.getWidget();
    }

    @Override
    public void updateCaption(ComponentConnector component) {
        // NOP, custom component dont render composition roots caption
    }

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent event) {
        super.onConnectorHierarchyChange(event);

        ComponentConnector newChild = null;
        if (getChildComponents().size() == 1) {
            newChild = getChildComponents().get(0);
        }

        VCustomComponent customComponent = getWidget();
        customComponent.setWidget(newChild.getWidget());

    }
}