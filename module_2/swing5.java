import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class swing5 {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Library Management");

        frame.setSize(700, 500);
        frame.setLayout(new FlowLayout());

        JTextField id =
                new JTextField(8);

        JTextField title =
                new JTextField(12);

        JTextField author =
                new JTextField(12);

        JComboBox<String> category =
                new JComboBox<>();

        category.addItem("Programming");
        category.addItem("Science");
        category.addItem("Fiction");
        category.addItem("History");

        JButton add =
                new JButton("Add");

        JButton delete =
                new JButton("Delete");

        JButton clear =
                new JButton("Clear");

        String[] columns =
                {"ID", "Title", "Author", "Category"};

        DefaultTableModel model =
                new DefaultTableModel(columns, 0);

        JTable table =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(table);

        frame.add(new JLabel("Book ID"));
        frame.add(id);

        frame.add(new JLabel("Title"));
        frame.add(title);

        frame.add(new JLabel("Author"));
        frame.add(author);

        frame.add(category);

        frame.add(add);
        frame.add(delete);
        frame.add(clear);

        frame.add(scrollPane);

        add.addActionListener(e -> {

            model.addRow(new Object[] {
                    id.getText(),
                    title.getText(),
                    author.getText(),
                    category.getSelectedItem()
            });
        });

        delete.addActionListener(e -> {

            int row =
                    table.getSelectedRow();

            if (row == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a row");

            } else {

                model.removeRow(row);
            }
        });

        clear.addActionListener(e -> {

            id.setText("");
            title.setText("");
            author.setText("");
        });

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}