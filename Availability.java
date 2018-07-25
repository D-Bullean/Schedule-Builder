import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.time.DayOfWeek;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.internal.dnd.SwtUtil;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.DateTime;
import swing2swt.layout.BoxLayout;

import java.awt.Window;
import java.awt.event.*;
import org.eclipse.jface.viewers.CheckboxTableViewer;
/*Creates a window to edit/create a new Employee in the schedule builder
 * Includes String name,
 * 
 * 
 * 
 * 
 * */
public class Availability {

	protected Shell shell;
	protected int startTime = 8;
	protected int endTime = 22;//10pm
	protected int timeFrame = endTime-startTime;
	protected String name = new String();
	protected Label[] daysOfWeek = new Label[6];
	protected Label[] workTime = new Label[timeFrame];
	protected Label[] filler = new Label[4];
	protected String[] timeArray = new String[timeFrame];
	protected Button[][] buttonArray = new Button[workTime.length][daysOfWeek.length];
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Availability window = new Availability();
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
	
	public String[] populateTime() {
		String[] frame = new String[timeFrame];
		int currentTime = startTime;
		for(int x=0;x<timeFrame;x++)
		{
			String temp;
			if(currentTime > 12)
			{
				temp = Integer.toString(currentTime-12);
				frame[x] = temp;
			}else {
				temp = Integer.toString(currentTime);
				frame[x] = temp;
			}
			currentTime++;
				
		}
		return frame;
	}

	/**
	 * Create contents of the window.
	 */

	protected void createContents() {
		shell = new Shell();
		shell.setSize(400, 400);
		shell.setText("Make Student");
		shell.setLayout(new GridLayout(daysOfWeek.length, false));
		
		//create an array with hours on a 12 hour scale
		timeArray= populateTime();
		
		//Creates a header for String name
		Label nameLabel = new Label(shell, SWT.NONE);
		nameLabel.setText("Name:");
		Text nameInput = new Text(shell, SWT.CENTER);
		
		//Fills in top row with blank labels to keep grid layout
		for(int x=0;x<filler.length;x++) {
			filler[x]= new Label(shell, SWT.NONE);
		};

		//Initialize Header Row with day of week
		for(int x = 0; x < daysOfWeek.length;x++) {
			daysOfWeek[x] = new Label(shell, SWT.NONE);
		}
		daysOfWeek[0].setText("Schedule");
		daysOfWeek[1].setText("Monday");
		daysOfWeek[2].setText("Tuesday");
		daysOfWeek[3].setText("Wednesday");
		daysOfWeek[4].setText("Thursday");
		daysOfWeek[5].setText("Friday");
		
		//Iterates through a row the size of workTime
		for(int x=0;x<workTime.length;x++) {
			workTime[x] = new Label(shell, SWT.NONE);
			workTime[x].setLayoutData(new GridData(SWT.CENTER,SWT.CENTER,false,false,1,1));
			workTime[x].setText(timeArray[x]);
			
			for(int y= 0;y<daysOfWeek.length-1;y++) {
				buttonArray[x][y] = new Button(shell,SWT.CHECK);
				buttonArray[x][y].setAlignment(SWT.CENTER);
			}
		}
		//GUI Button to checkAvailability
		Button btnCheckedBoxes = new Button(shell, SWT.NONE);
		btnCheckedBoxes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getAvailability();
			}
		});
		btnCheckedBoxes.setText("Checked Boxes");
		
		//Submit button GUI and event handler
		Button btnSubmit = new Button(shell, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!nameInput.getText().isEmpty()){
					name = nameInput.getText();
					submitEmployee(name);
					shell.close();
				}else{
					System.out.println("Please fill in the name");
				}			
			}
		});
		GridData gd_btnSubmit = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
		gd_btnSubmit.widthHint = 82;
		btnSubmit.setLayoutData(gd_btnSubmit);
		btnSubmit.setText("Submit");
		
		
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		

	}
	
	//Parse through and prints out Coordinates of double array
	protected void getAvailability() {
		for(int x=0;x<daysOfWeek.length-1;x++) {
			for(int y=0;y<workTime.length;y++) {
				if(buttonArray[y][x].getSelection() == true) {
					
					//System.out.print(daysOfWeek[x+1].getText()+":");
					//System.out.println(workTime[y].getText());
					System.out.println("["+y+"]["+x+"]");
				}
				
			}
		}
		
	}
	//Submit button function will return a string name and coordinates for which days are available
	protected boolean submitEmployee(String nameStr) {
		if(!nameStr.isEmpty()) {
			return true;
			
		}else {
			return false;
		}
	}
}
