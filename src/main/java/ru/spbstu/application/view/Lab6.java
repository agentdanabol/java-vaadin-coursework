package ru.spbstu.application.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import ru.spbstu.application.service.lab6.AbstractProgram;
import ru.spbstu.application.service.lab6.Supervisor;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Lab6")
@Route(value = "lab6")
public class Lab6 extends HorizontalLayout implements BaseView {

    private Div home;
    private VerticalLayout left_container;
    private VerticalLayout right_container;

    public Lab6() {
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
        Button start = new Button("Start", VaadinIcon.START_COG.create());
        left_container.add(start);

        start.addClickListener(e -> threading());
    }

    public void threading() {
        List<String> layout = new ArrayList<>();

        AbstractProgram program = new AbstractProgram();
        Supervisor supervisor = new Supervisor(program, layout);
        Thread programThread = new Thread(program);
        Thread supervisorThread = new Thread(supervisor);
        programThread.start();
        supervisorThread.start();

        try {
            programThread.join();
            supervisorThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        layout.forEach((e) -> right_container.add(createDiv(e)));
    }

}
