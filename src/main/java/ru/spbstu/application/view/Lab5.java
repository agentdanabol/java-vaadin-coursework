package ru.spbstu.application.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import ru.spbstu.application.service.lab5.Function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@PageTitle("Lab5")
@Route(value = "lab5")
public class Lab5 extends HorizontalLayout implements BaseView {

    private Div home;
    private VerticalLayout left_container;
    private VerticalLayout right_container;

    public Lab5() {
        home = new Div();
        home.add(new RouterLink("Main", MainView.class));
        left_container = new VerticalLayout();
        right_container = new VerticalLayout();
        add(home, left_container, right_container);
        setMargin(true);

        interact();
    }

    @Override
    public void interact() {
        TextField intArrayInput = new TextField("Integer array");
        Button intArraySubmit = new Button("Submit", VaadinIcon.CHECK.create());
        TextField stringArrayInput = new TextField("String array");
        Button stringArraySubmit = new Button("Submit", VaadinIcon.CHECK.create());
        left_container.add(intArrayInput, intArraySubmit, stringArrayInput, stringArraySubmit);

        intArraySubmit.addClickListener(e -> {
            intPart(intArrayInput.getValue());
        });
        stringArraySubmit.addClickListener(e -> {
            stringPart(stringArrayInput.getValue());
        });
    }

    public void intPart(String intArray) {
        String[] split = intArray.split(" ");
        List<Integer> list = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());

        right_container.add(
                createDiv("Исходная коллекция: "),
                createDiv(list.toString()),
                createDiv("Результаты: "),
                createDiv(Function.getAverageValue(list).toString()),
                createDiv(Function.getLonelySquareList(list).toString()),
                createDiv("\n" + Function.getEvenSum(list))
        );
    }

    public void stringPart(String stringArray) {
        String[] split = stringArray.split(" ");
        List<String> list = Arrays.stream(split).collect(Collectors.toList());

        right_container.add(
                createDiv("Исходная коллекция: "),
                createDiv(list.toString()),
                createDiv("Результаты: "),
                createDiv(Function.toUpperCase(list).toString()),
                createDiv(Function.getSortedStrings('a', list).toString()),
                createDiv(Function.getLast(list)),
                createDiv(Function.convertToMap(list).toString())
        );
    }

}
