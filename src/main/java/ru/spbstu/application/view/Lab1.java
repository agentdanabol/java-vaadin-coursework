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
import ru.spbstu.application.service.lab1.Hero;
import ru.spbstu.application.service.lab1.Point;

@PageTitle("Lab1")
@Route(value = "lab1")
public class Lab1 extends HorizontalLayout implements BaseView {

    private Div home;
    private VerticalLayout left_container;
    private VerticalLayout right_container;

    public Lab1() {
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
        try {
            Hero magicHero = new Hero(0, 0);
            right_container.add(createDiv("Я заспавнился!"));

            Point point1 = new Point(2, 8);
            magicHero = heroAction(point1, magicHero);

            Point point2 = new Point(-32, 9);
            magicHero = heroAction(point2, magicHero);

            Point point3 = new Point(24, 15);
            magicHero = heroAction(point3, magicHero);
        }
        catch (Exception e) {
            e.printStackTrace();
            right_container.add(createDiv("Упс... Что-то пошло не так."));
        }
    }

    public Hero heroAction(Point point, Hero magicHero) {
        TextField input = new TextField("Type strategy: ");
        Button submit = new Button("Submit", VaadinIcon.CHECK.create());
        submit.addClickListener(e -> {
            magicHero.setStrategy(input.getValue());
            magicHero.travel(point);
            right_container.add(createDiv("Передвигаюсь в точку: " + point));
        });
        left_container.add(input, submit);

        return magicHero;
    }

}