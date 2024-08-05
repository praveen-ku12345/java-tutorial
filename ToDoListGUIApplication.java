import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

abstract class TaskDemo {
    public abstract String getTitle();

    public abstract String getDescription();

    public abstract boolean isCompleted();

    public abstract void markAsCompleted();

    public abstract String toString();
}

class Task extends TaskDemo {
    private String title;
    private String description;
    private boolean isCompleted;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
    }

    public Task(String title) {
        this(title, "");
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nStatus: " + (isCompleted ? "Completed" : "Not Completed");
    }
}

class ToDoList {
    private List<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title, String description) {
        Task task = new Task(title, description);
        tasks.add(task);
    }

    public void addTask(String title) {
        Task task = new Task(title);
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsCompleted();
        }
    }

    public void removeCompletedTasks() {
        tasks.removeIf(Task::isCompleted);
    }
}

class TaskGUI extends JFrame {
    private ToDoList toDoList;

    private JTextArea taskTextArea;

    public TaskGUI() {
        super("To-Do List Application");
        toDoList = new ToDoList();

        taskTextArea = new JTextArea();
        taskTextArea.setEditable(false);

        JButton addTaskButton = new JButton("Add Task");
        JButton viewTasksButton = new JButton("View Tasks");
        JButton markCompletedButton = new JButton("Mark as Completed");
        JButton removeCompletedButton = new JButton("Remove Completed Tasks");

        setLayout(new BorderLayout());
        add(new JScrollPane(taskTextArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addTaskButton);
        buttonPanel.add(viewTasksButton);
        buttonPanel.add(markCompletedButton);
        buttonPanel.add(removeCompletedButton);

        add(buttonPanel, BorderLayout.SOUTH);

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter Task Title:");
                if (title != null && !title.trim().isEmpty()) {
                    String description = JOptionPane.showInputDialog("Enter Task Description:");
                    toDoList.addTask(title, description);
                    updateTaskTextArea();
                } else {
                    JOptionPane.showMessageDialog(TaskGUI.this, "Task title cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTaskTextArea();
            }
        });

        markCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskNumberStr = JOptionPane.showInputDialog("Enter Task Number to Mark as Completed:");
                try {
                    int taskNumber = Integer.parseInt(taskNumberStr);
                    toDoList.markTaskAsCompleted(taskNumber - 1);
                    updateTaskTextArea();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TaskGUI.this, "Invalid Task Number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toDoList.removeCompletedTasks();
                updateTaskTextArea();
            }
        });

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateTaskTextArea() {
        List<Task> tasks = toDoList.getTasks();
        StringBuilder taskText = new StringBuilder("Tasks:\n");

        for (int i = 0; i < tasks.size(); i++) {
            taskText.append("Task ").append(i + 1).append(":\n").append(tasks.get(i)).append("\n");
        }

        taskTextArea.setText(taskText.toString());
    }
}

public class ToDoListGUIApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskGUI();
            }
        });
    }
}