package ru.spbstu.application.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;

public interface BaseView {

    void interact();

    default Div createDiv(String text) {
        return new Div(new Text(text));
    }

}
