import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;


public class Launcher {

	protected Shell shell;
	protected int empCount = 0;
	protected ArrayList<String> currentEmployees = new ArrayList<>();
	protected Availability availability = new Availability();
	protected ToolItem[] empArray = new ToolItem[20];
	protected ArrayList<ToolItem> empList = new ArrayList<ToolItem>();
	protected ToolBar toolBar;

	/*
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Launcher window = new Launcher();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		//Creates the shell of the gui, this includes setting the size,and display text, all other content is contained within the shell
		shell = new Shell();
		shell.setSize(500, 500);
		shell.setText("Launcher");
		shell.setLayout(new GridLayout(2, false));
		//Creates a label and then sets the text to be current employees
		Label lblCurrentEmployees = new Label(shell, SWT.NONE);
		lblCurrentEmployees.setText("Current Employees");
		//Blank label to fill in the 2nd tile in the GridLayout
		new Label(shell, SWT.NONE);
		
		//Creates a Toolbar which will be used to store employee data
		toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT | SWT.VERTICAL);
				
		
		//Add employee gui button
		Button btnAddEmployee = new Button(shell, SWT.NONE);
		//Add Event Handler for when Add Employee button us clicked
		btnAddEmployee.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				availability.open();
				if(availability.submitEmployee(availability.name)) {
					addCurrentEmployee();
					for(int x=0;x<empList.size();x++) {
						empArray[x]=new ToolItem(toolBar, SWT.NONE);
						empArray[x].setText(currentEmployees.get(x));
					}
				}else {
					System.out.println("Adding Employee Canceled");
				}
			}
		});
		btnAddEmployee.setText("Add Employee");
		
		//Schedule Generator button
		Button btnGenerateSchedule = new Button(shell, SWT.NONE);
		btnGenerateSchedule.setText("Generate Schedule");
		new Label(shell, SWT.NONE);
		
		
	}
	//Add Employee to ArrayList
	protected ToolItem addCurrentEmployee() {
		empList.add(empCount,new ToolItem(toolBar, SWT.NONE));
		currentEmployees.add(availability.name);
		empList.get(empCount).addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				removeCurrentEmployee();
			}
		});
		//Setting current ToolItem text to the employee that was just added to the array list
		empList.get(empCount).setText(currentEmployees.get(empCount));
		System.out.println(currentEmployees.get(empCount));
		empCount++;
		return empList.get(empCount-1);
	}
	protected void removeCurrentEmployee() {
		String temp;
		temp = empList.get(empCount-1).getText();
		if(empCount == 0) {
			System.out.println("Can't remove element from empty set");
		}else {
			empList.remove(empCount-1);
			empCount--;	
			System.out.println("Removed Element:"+temp);
			System.out.println(empCount);
		}
		
	}
}
