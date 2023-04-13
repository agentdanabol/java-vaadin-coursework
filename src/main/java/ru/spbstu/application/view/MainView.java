package ru.spbstu.application.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@PageTitle("Main")
@Route(value = "")
public class MainView extends VerticalLayout {

    private Div container;
    private Div lab1;
    private Div lab2;
    private Div lab3;
    private Div lab4;
    private Div lab5;
    private Div lab6;

    public MainView() {
        lab1 = new Div();
        lab2 = new Div();
        lab3 = new Div();
        lab4 = new Div();
        lab5 = new Div();
        lab6 = new Div();

        lab1.add(new RouterLink("Lab1", Lab1.class));
        lab2.add(new RouterLink("Lab2", Lab2.class));
        lab3.add(new RouterLink("Lab3", Lab3.class));
        lab4.add(new RouterLink("Lab4", Lab4.class));
        lab5.add(new RouterLink("Lab5", Lab5.class));
        lab6.add(new RouterLink("Lab6", Lab6.class));

        Header header = new Header();
        header.add("Welcome!");
        header.setWidth("100%");
        header.setHeight("100px");

        container = new Div();
        container.add(lab1, lab2, lab3, lab4, lab5, lab6);

        container.setId("main-container");
        container.setWidth("100%");
        container.setHeight("300px");

        setMargin(true);
        add(header, container);
    }

}
