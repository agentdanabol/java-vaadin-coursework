package ru.spbstu.application.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import ru.spbstu.application.service.lab2.Car;
import ru.spbstu.application.service.lab2.MyAnnotation;

import java.lang.reflect.Method;

@PageTitle("Lab2")
@Route(value = "lab2")
public class Lab2 extends HorizontalLayout implements BaseView {

    private Div home;
    private VerticalLayout left_container;
    private VerticalLayout right_container;

    public Lab2() {
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
        Button submit = new Button("Start", VaadinIcon.START_COG.create());
        left_container.add(submit);
        submit.addClickListener(e -> start());
    }

    public void start() {
        try {
            Car car = new Car("Toyota", "Danil", "Japan car");
            Class<? extends Car> carClass = car.getClass();

            for (Method method : carClass.getDeclaredMethods()) {
                MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);

                method.setAccessible(true);

                if (myAnnotation == null) {
                    continue;
                }
                for (int i = 0; i < myAnnotation.count(); i++) {
                    right_container.add(createDiv(method.invoke(car).toString()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
