package ru.spbstu.application.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import ru.spbstu.application.service.lab3.ChordateAbstract;
import ru.spbstu.application.service.lab3.Function;
import ru.spbstu.application.service.lab3.animals.*;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Lab3")
@Route(value = "lab3")
public class Lab3 extends HorizontalLayout implements BaseView {

    private Div home;
    private VerticalLayout left_container;
    private VerticalLayout right_container;

    public Lab3() {
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
        List<ChordateAbstract> srcCollection = new ArrayList<>();
        Mammal animal1 = new HedgehogCommon("Hedgehog1");
        Mammal animal2 = new Manul("Manul1");
        Mammal animal3 = new Lynx("Lynx1");
        Insectivore animal4 = new HedgehogCommon("Hedgehog2");
        Feline animal5 = new Lynx("Lynx2");

        srcCollection.add(animal1);
        srcCollection.add(animal2);
        srcCollection.add(animal3);
        srcCollection.add(animal4);
        srcCollection.add(animal5);


        List<Hedgehog> collection1 = new ArrayList<>();
        List<Feline> collection2 = new ArrayList<>();
        List<Lynx> collection3 = new ArrayList<>();

        Function.segregate(srcCollection, collection1, collection2, collection3);

        Button submit = new Button("Start", VaadinIcon.START_COG.create());
        left_container.add(submit);
        submit.addClickListener(e -> {
            start(collection1);
            start(collection2);
            start(collection3);
        });

    }

    public <T> void start(List<T> collection) {
        right_container.add(createDiv("Collection: "));
        collection.forEach((e) -> right_container.add(createDiv(e.toString())));
    }
}
