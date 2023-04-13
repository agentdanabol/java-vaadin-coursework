package ru.spbstu.application.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import ru.spbstu.application.service.lab4.Dictionary;
import ru.spbstu.application.service.lab4.FileParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@PageTitle("Lab4")
@Route(value = "lab4")
public class Lab4 extends HorizontalLayout implements BaseView {

    private Div home;
    private VerticalLayout left_container;
    private VerticalLayout right_container;

    public Lab4() {
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
            File base = new File("src/main/java/ru/spbstu/application/service/lab4/data/dictionary.txt");
            File input = new File("src/main/java/ru/spbstu/application/service/lab4/data/input.txt");

            BufferedReader baseReader = new BufferedReader(new FileReader(base));
            BufferedReader inputReader = new BufferedReader(new FileReader(input));

            FileParser fileParser = new FileParser();
            Map<String, String> wordsMap = new HashMap<>(fileParser.parse(baseReader));

            Dictionary dictionary = new Dictionary(wordsMap);

            Button submit = new Button("Start", VaadinIcon.ENTER.create());
            left_container.add(submit);
            submit.addClickListener(e -> start(inputReader, dictionary));

            baseReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(BufferedReader inputReader, Dictionary dictionary) {
        try {
            String line = inputReader.readLine();
            while (line != null) {
                right_container.add(createDiv(line + ": " + dictionary.translate(line)));
                line = inputReader.readLine();
            }
            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
