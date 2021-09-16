package com.chujian.ups.annotator;

import javax.lang.model.element.VariableElement;

public class VariableInfo {
        int viewId;

    public int getViewId() {
        return viewId;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }

    public VariableElement getVariableElement() {
        return variableElement;
    }

    public void setVariableElement(VariableElement variableElement) {
        this.variableElement = variableElement;
    }

        VariableElement variableElement;

}
