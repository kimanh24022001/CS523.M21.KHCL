import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.util.Random;
public class bitTree   extends JFrame  implements ActionListener, ChangeListener,Runnable  {
	int[] BITree = new int[200000];
	int n=17;
	int[] a= new int[100];
	int[] b= new int[100];
	int[] c= new int[100];
    int[] mark=new int[100];
    int[] add=new int[100];
    JPanel panel;
    JLabel label;
    JSlider slider;
    JPanel panel_1 = new JPanel();
    JPanel panel_2 = new JPanel();
	JLabel[] Labels = new JLabel[17];	
	JButton random = new JButton();
	JButton stop = new JButton();
	JButton goback = new JButton();
	JButton go_1 = new JButton();
	JButton go_2 = new JButton();
	JButton start = new JButton();
	JButton update = new JButton();
	JButton rsq = new JButton();
	JButton next = new JButton();
	JButton option_1 = new JButton();
	JButton option_2 = new JButton();
	JButton run = new JButton();
	JButton sub = new JButton();
	JTextField input = new JTextField();
	JLabel text = new JLabel();
	JTextField left = new JTextField();
	JTextField right = new JTextField();
	JTextField pos = new JTextField();
	JTextField delta = new JTextField();
	JTextArea exp1 = new JTextArea();
	JTextArea exp2 = new JTextArea();
	JTextArea exp3 = new JTextArea();
	JTextArea exp4 = new JTextArea();

	JLabel title = new JLabel();
	String[] numbers ;
	int turnon=0;
	int flag=0,markColor=0;
	int T=1;
	int seconds=3;
	int index=0;
	int count=0,x=0;
	int leftV,rightV,posV,deltaV=0;
	int danhdau=0;
	int checkOption=0;
	ImageIcon img= new ImageIcon("C:\\Users\\DELL\\eclipse-workspace\\fenwick tree\\src\\img.png");
	ImageIcon img1= new ImageIcon("C:\\Users\\DELL\\eclipse-workspace\\fenwick tree\\src\\images\\1.png");
	ImageIcon img2= new ImageIcon("C:\\Users\\DELL\\eclipse-workspace\\fenwick tree\\src\\images\\2.png");
	ImageIcon img3= new ImageIcon("C:\\Users\\DELL\\eclipse-workspace\\fenwick tree\\src\\images\\3.png");
	ImageIcon img4= new ImageIcon("C:\\Users\\DELL\\eclipse-workspace\\fenwick tree\\src\\images\\4.png");
	public bitTree () throws InterruptedException {
		 super("fenwick");     
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1600,2500);
		this.getContentPane().setBackground(Color.white);
		this.setLayout(null);
		this.setResizable(false);	
		
		input.setText("Enter a array");
		input.setBounds(500,600,200,50);
		input.setFont(new Font("MV Boli",Font.BOLD,20));
		input.setForeground( Color.gray);	
		input.setBackground( Color.white);
		input.setOpaque(true);
		
		text.setFont(new Font("MV Boli",Font.BOLD,18));		
		text.setForeground(Color.black);
		title.setBounds(400,100,300,300);
		title.setFont(new Font("MV Boli",Font.BOLD,50));		
		title.setText("Cây Fenwick");
		title.setForeground(Color.black);
		
	//	exp1.setBounds(963,200,400,70);
		exp1.setBounds(3000,200,400,100);
		exp1.setFont(new Font("MV Boli",Font.BOLD,14));		
		exp1.setForeground(Color.black);
		exp1.setText("                 STEP ONE: \n"
				+ "Constructs and returns a Binary Indexed Tree for given\n"
		+"array of size n. Create and initialize BITree as 0");
		exp2.setBounds(3000,200,400,100);
		exp2.setFont(new Font("MV Boli",Font.BOLD,14));		
		exp2.setForeground(Color.black);
		exp2.setText("                 STEP TWO \n"
				+ "Store the actual values in BITree using update");
		exp2.setForeground(Color.black);

		exp3.setBounds(3000,200,400,100);
		exp3.setFont(new Font("MV Boli",Font.BOLD,14));		
		exp3.setForeground(Color.black);
		exp3.setText("Let use test the update operation");
		exp3.setForeground(Color.black);
		
		exp4.setBounds(3000,200,400,100);
		exp4.setFont(new Font("MV Boli",Font.BOLD,14));		
		exp4.setForeground(Color.black);		
		exp4.setText("Find sums of array elements are stored in BITree.");
		exp4.setForeground(Color.black);
		
		
		random.setBounds(700,600,150,50);
		random.setFont(new Font("MV Boli",Font.BOLD,18));
		random.setFocusable(false);
		random.addActionListener(this);
		random.setText("Randomize");
		random.setBackground(new Color(135,206,235));
		random.setForeground(Color.black);
		random.setBorder(new RoundBtn(15));   
		
		stop.setBounds(200,572,50,50);
		stop.setFont(new Font("MV Boli",Font.BOLD,18));
		stop.setFocusable(false);
		stop.addActionListener(this);
		stop.setIcon(img1);
		stop.setBackground(Color.white);
		stop.setBorder(new RoundBtn(80));   

		sub.setBounds(10,0,90,40);
		sub.setFont(new Font("MV Boli",Font.BOLD,15));
		sub.setFocusable(false);
		sub.addActionListener(this);
		sub.setText("Explain!");
		sub.setBackground(Color.white); 
		sub.setOpaque(true);
		
		goback.setBounds(120,572,50,50);
		goback.setFont(new Font("MV Boli",Font.BOLD,18));
		goback.setFocusable(false);
		goback.addActionListener(this);
		goback.setIcon(img3);
		goback.setBackground(Color.white);
		goback.setBorder(new RoundBtn(80));   
		
		next.setBounds(190,572,55,55);
		next.setFont(new Font("MV Boli",Font.BOLD,18));
		next.setFocusable(false);
		next.addActionListener(this);
		next.setIcon(img4);
		next.setBackground(Color.white);
		next.setBorder(new RoundBtn(80));   
		
		go_1.setBounds(1320,480,50,75);
		go_1.setFont(new Font("MV Boli",Font.BOLD,14));
		go_1.setFocusable(false);
		go_1.addActionListener(this);
		go_1.setText("Go");
		go_1.setBackground(new Color(135,206,235));
		go_1.setForeground(Color.black);
		
		go_2.setBounds(1320,480,50,75);
		go_2.setFont(new Font("MV Boli",Font.BOLD,14));
		go_2.setFocusable(false);
		go_2.addActionListener(this);
		go_2.setText("Go");
		go_2.setBackground(new Color(135,206,235));
		go_2.setForeground(Color.black);
		
		update.setBounds(1320,540,50,60);
		update.setFont(new Font("MV Boli",Font.BOLD,15));
		update.setFocusable(false);
		update.addActionListener(this);
		update.setText("<");
		update.setBackground(new Color(223,53,57));
		update.setForeground(Color.white);
		
		rsq.setBounds(1320,480,50,60);
		rsq.setFont(new Font("MV Boli",Font.BOLD,15));
		rsq.setFocusable(false);
		rsq.addActionListener(this);
		rsq.setText("<");
		rsq.setBackground(new Color(223,53,57));
		rsq.setForeground(Color.white);
		
		start.setBounds(670,670,50,50);
		start.setFont(new Font("MV Boli",Font.BOLD,18));
		start.setFocusable(false);
		start.addActionListener(this);
		start.setIcon(img);
		start.setBorder(new RoundBtn(15));   
		start.setBackground( Color.white);
		
		//panel.setText("Enter a array");
		panel_1.setBounds(3000,480,200,60);
		panel_1.setFont(new Font("MV Boli",Font.BOLD,20));
		panel_1.setForeground( Color.gray);	
		panel_1.setBackground( new Color(245,168,154));
		panel_1.setOpaque(true);
		panel_2.setBounds(3000,540,200,60);
		panel_2.setFont(new Font("MV Boli",Font.BOLD,20));
		panel_2.setForeground( Color.gray);	
    	panel_2.setBackground( new Color(245,168,154));
		panel_2.setOpaque(true);
		
	//	left.setSize(100,50);
		left.setFont(new Font("MV Boli",Font.BOLD,20));		
		left.setText("l = ");
		left.setForeground(Color.gray);
		left.setBackground( Color.white);
		left.setOpaque(true);
     	right.setBounds(420,600,50,50);
		right.setFont(new Font("MV Boli",Font.BOLD,20));		
		right.setText("r = ");
		right.setForeground(Color.gray);
		right.setBackground(Color.white);
		pos.setBounds(420,600,50,50);
		pos.setFont(new Font("MV Boli",Font.BOLD,16));		
		pos.setText("pos =");
		pos.setForeground(Color.gray);
		pos.setBackground(Color.white);
		delta.setBounds(420,600,50,50);
		delta.setFont(new Font("MV Boli",Font.BOLD,16));		
		delta.setText("delta =");
		delta.setForeground(Color.gray);
		delta.setBackground(Color.white);
		
		for (int i=0;i<n;i++) {
	    	   Labels[i] = new JLabel();
	  //  	   b[i]=0;
	    	   mark[i+1]=0;
	    	   Labels[i].setForeground(Color.black);
	    	   Labels[i].setText(i+"");
	    	   this.add(Labels[i]);
	    	   Labels[i].setOpaque(true);
		}
		for (int i=1; i<=n; i++)
	    {  BITree[i] = 0;}
		option_1.setBounds(900,500,150,50);
		option_1.setFont(new Font("MV Boli",Font.BOLD,18));
		option_1.setFocusable(false);
		option_1.addActionListener(this);
		option_1.setText("Option 1");
		option_1.setBackground(new Color(214,255,229));
		option_1.setForeground(Color.black);
		option_1.setBorder(new RoundBtn(15));   

		option_2.setBounds(900,550,150,50);
		option_2.setFont(new Font("MV Boli",Font.BOLD,18));
		option_2.setFocusable(false);
		option_2.addActionListener(this);
		option_2.setText("Option 2");
		option_2.setBackground(new Color(214,255,229));
		option_2.setForeground(Color.black);
		option_2.setBorder(new RoundBtn(15));   
		run.setBounds(900,600,150,50);
		run.setFont(new Font("MV Boli",Font.BOLD,18));
		run.setFocusable(false);
		run.addActionListener(this);
		run.setText("Run");
		run.setBackground(new Color(51,153,255));
		run.setForeground(Color.black);
		run.setBorder(new RoundBtn(15));   
		panel = new JPanel();
		label = new JLabel();
		slider = new JSlider(0,200,20);
		panel.setBounds(100,650,200,50);
		panel.setBackground(Color.white);
		slider.setPreferredSize(new Dimension(200,20));	  
		label.setForeground(Color.blue);
		slider.setForeground(Color.blue);
		slider.setBackground(Color.white);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(15);  
		slider.setPaintLabels(true);
		slider.setFont(new Font("MV Boli",Font.PLAIN,15));
		label.setFont(new Font("MV Boli",Font.PLAIN,15));
		  //slider.setOrientation(SwingConstants.HORIZONTAL);
		slider.setOrientation(SwingConstants.HORIZONTAL);
		  
		label.setText("Speed: "+ slider.getValue());
		  
		slider.addChangeListener(this);
		this.add(sub);
		this.add(input);
		this.add(random);
		this.add(text);
		this.add(title);
		this.add(run);
		this.add(update);
		this.add(rsq);
		this.add(start);
		this.add(panel_1);
		this.add(panel_2);
		this.add(exp1);
		this.add(exp2);
		this.add(exp3);
		this.add(exp4);
		panel.add(slider);
		panel.add(label);
	    this.add(panel);
		panel_1.add(left);
		panel_1.add(right);
		panel_1.add(go_1);
		panel_2.add(pos);
		panel_2.add(delta);
		panel_2.add(go_2);
	//	TimeUnit.MINUTES.sleep(1);
		//container.add(slider);this.add(container);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	//	this.pack();
	}
	class RoundBtn implements Border 
	{
	    private int r;
	    RoundBtn(int r) {
	        this.r = r;
	    }
	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
	    }
	    public boolean isBorderOpaque() {
	        return true;
	    }
	    public void paintBorder(Component c, Graphics g, int x, int y, 
	    int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, r, r);
	    }
	}
	public static void wait(int ms)
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
    int findHat(int x) {
    	int t=0;
    	float tmp=x;
    	while(tmp%2==0){
    		tmp=tmp/2;
    		t++;
    	}
    	return t;
    }
	int getSum(int BITree[], int index)
	{
	    int sum = 0; // Initialize result
	 
	    // index in BITree[] is 1 more than the index in arr[]
	    index = index + 1;
	 
	    // Traverse ancestors of BITree[index]
	    while (index>0)
	    {
	        // Add current element of BITree to sum
	        sum += BITree[index];
	 
	        // Move index to parent node in getSum View
	        index -= index & (-index);
	    }
	    return sum;
	}
	 
	// Updates a node in Binary Index Tree (BITree) at given index
	// in BITree. The given value 'val' is added to BITree[i] and
	// all of its ancestors in tree.
	void updateBIT(int BITree[], int n, int index, int val)
	{
	    index = index + 1;
	 
	    while (index <= n)
	    {
	    // Add 'val' to current node of BI Tree
	    BITree[index] += val;
	 
	    // Update index to that of parent in update View
	    index += index & (-index);
	    }
	}
	int[] constructBITree(int arr[], int n)
	{
		    for (int i=1; i<=n; i++)
		    {  BITree[i] = 0;}
	 
	    // Store the actual values in BITree[] using update()
	        for (int i=0; i<n; i++) {
	           updateBIT(BITree, n, i, arr[i]);
	    }
	    return BITree;
	 
	}

	 @Override
	 public void stateChanged(ChangeEvent e) {
	  
	  label.setText("Speed: "+ slider.getValue());
	  T= slider.getValue();
	 }

	 Timer timer = new Timer(1, new ActionListener() {
		 @Override
			public void actionPerformed(ActionEvent e) {
		//	 flag=1;
			 if (turnon==1) {exp1.setBounds(30,200,400,100);}
			 else {
				  exp2.setBounds(3000,200,400,100);
				  exp1.setBounds(3000,200,400,100);
				  exp3.setBounds(3000,200,400,100);
			  }
			  if (seconds<=0 && seconds>=-8) {
				//  repaint();
			  }
			  else if (seconds<-8 && seconds>=-9) {
				  flag=2;
				 // seconds=0;
				  repaint();
				  //timer.stop();
			  }
			  
			  else if (seconds<-9) {
				  timer.stop();
				 // timer.continue();
				  for(int i=0;i<n;i++) {
				     Labels[i].setText(""+0);
				  }
				  if (checkOption==1) { flag=5; repaint();}
				  else{ timer_1.start();}
			  }
			  else {
				  repaint();
			  }
			  try {
					TimeUnit.MILLISECONDS.sleep((1900-T*10));
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 seconds--;
		 }
	 });
	 Timer timer_1 = new Timer(1, new ActionListener() {
		 @Override
			public void actionPerformed(ActionEvent e) {
			  flag=3;
			  if (turnon==1) {
				 exp2.setBounds(50,200,400,100);
				 exp1.setBounds(3000,200,400,100);
				 }
			  else {
				  exp2.setBounds(3000,200,400,100);
				  exp1.setBounds(3000,200,400,100);
				  exp3.setBounds(3000,200,400,100);
			  }
			  repaint();
			  Labels[b[count]].setText(""+BITree[b[count]+1]);
			  Labels[b[count]].setForeground(Color.blue);
		      count++;
			  if (count==index) {
					  timer_1.stop();
				 }
			  try {
					TimeUnit.MILLISECONDS.sleep(2500-T*12);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 }
	 });
	 Timer timer_2 = new Timer(1, new ActionListener() {
		 @Override
			public void actionPerformed(ActionEvent e) {
			 try {
					TimeUnit.MILLISECONDS.sleep(2500-T*12);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  flag=4;
			  Labels[posV].setForeground(Color.blue);
			  x=posV;
			  while (x <= n)
		       	    {
				  repaint();
				  x += x & (-x);	  		       	    
		       	    }
       	      timer_2.stop();
				 
		 }
	 });
	 Timer timer_3 = new Timer(1, new ActionListener() {
		 @Override
			public void actionPerformed(ActionEvent e) {
			 try {
					TimeUnit.MILLISECONDS.sleep(2500-T*12);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   if (markColor==1)
			    { repaint();}
       	      timer_3.stop();
				 
		 }
	 });
	public void paint(Graphics g) {
		super.paint(g);
		  Graphics2D g2D = (Graphics2D) g;
		  g2D.setStroke(new BasicStroke(2));
	//	  g2D.drawLine(0, 0, 80, 80);
		  if (flag==3) {
		    g2D.setPaint(Color.pink);
		  }
	
		    g2D.setPaint(Color.black);
		   g2D.setFont(new Font("Serif",Font.BOLD,14));

		    draw(g2D);
		 ////   timer.stop();
		 
		 }
	private void draw(Graphics2D g) {
		//if (timer.isStart()) {
		if (flag==2) {		
               for (int i=0;i<n;i++) {
            
			      // if (i==)
			       if (((i+1+((i+1)&(-i-1)))-1)<n) {
			          g.drawLine( 258-n*10+(i)*90, 460-50*findHat(i+1), 224-n*10+((i+1+((i+1)&(-i-1)))-1)*90, 455-50*findHat((i+1+((i+1)&(-i-1)))));
			       }
			       else {
				      g.drawLine( 258-n*10+(i)*90, 460-50*findHat(i+1), n*50+570,220-10*n);
				      g.drawOval(n*50+570,200-10*n,40,40);
	             	  g.drawString("R",n*50+580,220-10*n);  

			       }
			       g.drawOval(220-n*10+i*90,445-50*findHat(i+1), 40, 40);
             	   g.drawString(""+0,235-n*10+i*90,470-50*findHat(i+1));  
			       g.setFont( new Font("Serif",Font.BOLD, 14));
	
		      }	  
		}
		if (flag==3) {		
			
			   for (int i=0;i<n;i++) {	            
				      // if (i==)
				   g.setPaint(Color.black);
				   if(mark[i+1]==0) {
				       if (((i+1+((i+1)&(-i-1)))-1)<n) {
				          g.drawLine( 258-n*10+(i)*90, 460-50*findHat(i+1), 224-n*10+((i+1+((i+1)&(-i-1)))-1)*90, 455-50*findHat((i+1+((i+1)&(-i-1)))));
				       }
				       else {
					      g.drawLine( 258-n*10+(i)*90, 460-50*findHat(i+1), n*50+570,220-10*n);
					      g.drawOval(n*50+570,200-10*n,40,40);
		             	  g.drawString("R",n*50+580,220-10*n);  

				       }
				       g.drawOval(220-n*10+i*90,445-50*findHat(i+1), 40, 40);
	             	   g.drawString(""+0,235-n*10+i*90,470-50*findHat(i+1));  
				       g.setFont( new Font("Serif",Font.BOLD, 14));
			      }
			   }
			   for (int i=0;i<count;i++) {    
				   danhdau=0;
	                 mark[c[i]]=1;
                     g.setPaint(new Color(0,98,65)); 
	             	 if ((c[i]+((c[i])&(-c[i])))>n) {
	             		g.drawLine( 258-n*10+(c[i]-1)*90, 460-50*findHat(c[i]), n*50+570,220-10*n);             		
	             		g.fillOval(n*50+567,198-10*n,45,45);
	             		
	             		g.setPaint(Color.white);
		             	g.drawString("R",n*50+580,220-10*n);  
		             	if (i==count-1) {
		             		 g.setPaint(new Color(255,140,0));
	             		}
	             		else {
	             		   g.setPaint(new Color(0,98,65));
	             		   }
				       //   g.drawLine( 258-n*10+(c[i]-1)*90, 460-50*findHat(c[i]), 224-n*10+(c[i]+((c[i])&(-c[i]))-1)*90, 455-50*findHat(c[i]+((c[i])&(-c[i]))));
				        g.fillOval(218-n*10+(c[i]-1)*90,442-50*findHat((c[i]-1)+1), 45, 45);
				          
				        g.setPaint(Color.white);

		                g.drawString(""+add[i],235-n*10+(c[i]-1)*90,470-50*findHat(c[i])); 
	             	 }
	             	 else {
                           
	 	             		if (i==count-1) {
	 	             			 g.setPaint(new Color(255,140,0));
	 	             		}
	 	             		else {
	 	             		g.setPaint(new Color(0,98,65));}
				        g.drawLine( 258-n*10+(c[i]-1)*90, 460-50*findHat(c[i]), 224-n*10+(c[i]+((c[i])&(-c[i]))-1)*90, 455-50*findHat(c[i]+((c[i])&(-c[i]))));
				        g.fillOval(218-n*10+(c[i]-1)*90,442-50*findHat((c[i]-1)+1), 45, 45);
				          
				        g.setPaint(Color.white);
		             	g.drawString(""+add[i],235-n*10+(c[i]-1)*90,470-50*findHat(c[i])); 
	             	 }
			   }
					danhdau=1;	
		}
		if (flag==4) {		
			   for (int i=0;i<n;i++) {	            
				      // if (i==)
				   g.setPaint(Color.black);
				   if(mark[i+1]==0) {
				       if (((i+1+((i+1)&(-i-1)))-1)<n) {
				          g.drawLine( 258-n*10+(i)*90, 460-50*findHat(i+1), 224-n*10+((i+1+((i+1)&(-i-1)))-1)*90, 455-50*findHat((i+1+((i+1)&(-i-1)))));
				       }
				       else {
					      g.drawLine( 258-n*10+(i)*90, 460-50*findHat(i+1), n*50+570,220-10*n);
					      g.drawOval(n*50+570,200-10*n,40,40);
		             	  g.drawString("R",n*50+580,220-10*n);  

				       }
				       g.drawOval(220-n*10+i*90,445-50*findHat(i+1), 40, 40);
	             	   g.drawString(""+0,235-n*10+i*90,470-50*findHat(i+1));  
				       g.setFont( new Font("Serif",Font.BOLD, 14));
			      }
			   }
			   for (int i=0;i<index;i++) {         
	                  mark[c[i]]=1;
	             	 if ((c[i]+((c[i])&(-c[i])))>n) {
	             		
	             		g.setPaint(new Color(0,98,65));
	             		g.drawLine( 258-n*10+(c[i]-1)*90, 460-50*findHat(c[i]), n*50+570,220-10*n);             		
	             		g.fillOval(n*50+567,198-10*n,45,45);
	             		
	             		g.setPaint(Color.white);
		             	g.drawString("R",n*50+580,220-10*n);  
		             	
		             	g.setPaint(new Color(0,98,65));
				       //   g.drawLine( 258-n*10+(c[i]-1)*90, 460-50*findHat(c[i]), 224-n*10+(c[i]+((c[i])&(-c[i]))-1)*90, 455-50*findHat(c[i]+((c[i])&(-c[i]))));
				        g.fillOval(218-n*10+(c[i]-1)*90,442-50*findHat((c[i]-1)+1), 45, 45);
				          
				        g.setPaint(Color.white);

		                g.drawString(""+add[i],235-n*10+(c[i]-1)*90,470-50*findHat(c[i])); 
	             	 }
	             	 else {
	             		 
	             		g.setPaint(new Color(0,98,65));
				        g.drawLine( 258-n*10+(c[i]-1)*90, 460-50*findHat(c[i]), 224-n*10+(c[i]+((c[i])&(-c[i]))-1)*90, 455-50*findHat(c[i]+((c[i])&(-c[i]))));
				        g.fillOval(218-n*10+(c[i]-1)*90,442-50*findHat((c[i]-1)+1), 45, 45);
				          
				        g.setPaint(Color.white);
		             	g.drawString(""+add[i],235-n*10+(c[i]-1)*90,470-50*findHat(c[i])); 
	             	 }
			   }
			   int x=posV;
			 while (x <= n)
	       	    {
				 if (markColor==0) {
					 g.setPaint(new Color(255,140,0));}
				 else {g.setPaint(new Color(0,98,65));}
				 if (x+(x&(-x))<=n) {
		             g.drawLine( 258-n*10+(x-1)*90, 460-50*findHat(x), 224-n*10+(x+(x&(-x))-1)*90, 455-50*findHat(x+((x)&(-x))));
				 }
				 g.fillOval(218-n*10+(x-1)*90,442-50*findHat((x-1)+1), 45, 45);	          
		        g.setPaint(Color.white);
             	g.drawString(""+BITree[x],235-n*10+(x-1)*90,470-50*findHat(x));
	       	    x += x & (-x);	  
	       	    }
			    markColor++;
			    
			    timer_3.start();
	       	    
		}
		if (flag==5) {		
			
			   for (int i=0;i<n;i++) {	            
				      // if (i==)
				   g.setPaint(Color.black);
				   if(mark[i+1]==0) {
				       if (((i+1+((i+1)&(-i-1)))-1)<n) {
				          g.drawLine( 258-n*10+(i)*90, 460-50*findHat(i+1), 224-n*10+((i+1+((i+1)&(-i-1)))-1)*90, 455-50*findHat((i+1+((i+1)&(-i-1)))));
				       }
				       else {
					      g.drawLine( 258-n*10+(i)*90, 460-50*findHat(i+1), n*50+570,220-10*n);
					      g.drawOval(n*50+570,200-10*n,40,40);
		             	  g.drawString("R",n*50+580,220-10*n);  

				       }
				       g.drawOval(220-n*10+i*90,445-50*findHat(i+1), 40, 40);
	             	   g.drawString(""+0,235-n*10+i*90,470-50*findHat(i+1));  
				       g.setFont( new Font("Serif",Font.BOLD, 14));
			      }
			   }
			   for (int i=0;i<count;i++) {    
				   danhdau=0;
	                 mark[c[i]]=1;
                  g.setPaint(new Color(0,98,65)); 
	             	 if ((c[i]+((c[i])&(-c[i])))>n) {
	             		g.drawLine( 258-n*10+(c[i]-1)*90, 460-50*findHat(c[i]), n*50+570,220-10*n);             		
	             		g.fillOval(n*50+567,198-10*n,45,45);
	             		
	             		g.setPaint(Color.white);
		             	g.drawString("R",n*50+580,220-10*n);  
		             	if (i==count-1) {
		             		 g.setPaint(new Color(255,140,0));
	             		}
	             		else {
	             		   g.setPaint(new Color(0,98,65));
	             		   }
				       //   g.drawLine( 258-n*10+(c[i]-1)*90, 460-50*findHat(c[i]), 224-n*10+(c[i]+((c[i])&(-c[i]))-1)*90, 455-50*findHat(c[i]+((c[i])&(-c[i]))));
				        g.fillOval(218-n*10+(c[i]-1)*90,442-50*findHat((c[i]-1)+1), 45, 45);
				          
				        g.setPaint(Color.white);

		                g.drawString(""+add[i],235-n*10+(c[i]-1)*90,470-50*findHat(c[i])); 
	             	 }
	             	 else {
                        
	 	             		if (i==count-1) {
	 	             			 g.setPaint(new Color(255,140,0));
	 	             		}
	 	             		else {
	 	             		g.setPaint(new Color(0,98,65));}
				        g.drawLine( 258-n*10+(c[i]-1)*90, 460-50*findHat(c[i]), 224-n*10+(c[i]+((c[i])&(-c[i]))-1)*90, 455-50*findHat(c[i]+((c[i])&(-c[i]))));
				        g.fillOval(218-n*10+(c[i]-1)*90,442-50*findHat((c[i]-1)+1), 45, 45);
				          
				        g.setPaint(Color.white);
		             	g.drawString(""+add[i],235-n*10+(c[i]-1)*90,470-50*findHat(c[i])); 
	             	 }
			   }
		}
		//else {
		if (flag==1) {
			BITree=constructBITree(a,n);
	      for (int i=0;i<n-seconds;i++) {
	    	if ((100+i*90)>1200) {
	    		g.drawOval(-1075+i*90,120, 42, 42);
	    		g.drawString(""+a[i], -1065+i*90,145);  
	    	}
	    	else {
	         	g.drawOval(100+i*90,50, 42, 42);
	         	g.drawString(""+a[i],108+i*90,75);  
	    	}
	    	
	    	g.setFont( new Font("Serif",Font.BOLD, 14));
      }
	      if (flag==0) {}
	  //    flag=0;
	  //    }
		}
	}
	 @Override
	    public void run() {
	        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start ) {
			try {
				new bitTree();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==goback ) {
			timer_1.stop();
		    count=count-3;
		    timer_1.start();
		}
		if(e.getSource()==stop ) {
			if (stop.getIcon()==img1)
			   {
				stop.setIcon(img2);
			  }
			else {stop.setIcon(img1);}
			if (count<index && stop.getIcon()==img2 ) {
			      try {
			    	  stop.setIcon(img2);
					TimeUnit.SECONDS.sleep(5);
				   } catch (InterruptedException e1) {
					e1.printStackTrace();
					}
				}
		}
		if(e.getSource()==go_1 ) {
			if (turnon==1) {
				 exp2.setBounds(3000,200,400,100);
				 exp3.setBounds(50,200,400,100);
				 exp3.setText("Find sums of array elements are \n"
				 		+ "stored in BITree.");
				 }
		    else {
			  exp2.setBounds(3000,200,400,100);
			  exp1.setBounds(3000,200,400,100);
			  exp3.setBounds(3000,200,400,100);
		    }
			leftV=Integer.parseInt(left.getText());
			rightV=Integer.parseInt(right.getText());
			int tmp=getSum( BITree, rightV-1)-getSum( BITree, leftV-2);
			text.setBounds(400,40,400,40);
			if ((leftV-1)>0) {
			  text.setText("Sum("+ leftV+","+rightV+") ="+"Sum("+ 1+","+rightV+") -"+"Sum("+ 1+","+(leftV-1)+") ="+tmp);
			}
			else {
				 text.setText("Sum("+ 1+","+rightV+") ="+tmp) ;
			}
		}
		if(e.getSource()==go_2 ) {
			posV=Integer.parseInt(pos.getText());
			deltaV=Integer.parseInt(delta.getText());
			int x=posV;
			updateBIT(BITree, n, x-1, deltaV);
			flag=4;
			if (turnon==1) {
				 exp2.setBounds(3000,200,400,100);
				 exp1.setBounds(3000,200,400,100);
				 exp3.setBounds(50,200,400,100);
				 }
		   else {
			  exp2.setBounds(3000,200,400,100);
			  exp1.setBounds(3000,200,400,100);
			  exp3.setBounds(3000,200,400,100);
		   }
       	   repaint();
       
		}
		if(e.getSource()==sub ) {
			if (turnon==0) {turnon=1;}
			else {
				turnon=0;
				}
		}
		if(e.getSource()==update ) {
			if (panel_2.getX()>1140) {
			  panel_2.setBounds(1140,540,200,60);
			}
			else {
				panel_2.setBounds(3000,540,200,60);
			}
		}
		if(e.getSource()==rsq ) {
			if (panel_1.getX()>1140) {
			panel_1.setBounds(1140,480,200,60);
			}
			else {
				panel_1.setBounds(3000,480,200,60);
			}		
		}
		if(e.getSource()==random ) {
			//   this.remove(title);
			   Random rd = new Random();		   
		       input.setText("");
		       for (int i=0;i<n;i++) {
		    	   Labels[i].setText("");
		    	 //  this.move(Labels[i]);
		       }
		       n = rd.nextInt(16);
		       for (int i=0;i<n;i++) {
		    //	   Labels[i] = new JLabel();
		    	   
		    	   Labels[i].setBounds(100+i*90,500,90,50);
		    	   if (Labels[i].getX()>1200) {
		    		   Labels[i].setBounds(-1075+i*90,540,90,50);
		    	   }
		    	   Labels[i].setFont(new Font("Serif",Font.BOLD,16));
		    	   Labels[i].setFocusable(false);
		    	   Labels[i].setForeground(Color.black);	
		    	   Labels[i].setBackground(Color.white);	
		    	   Labels[i].setText(i+"");
		    	   Labels[i].setOpaque(true);
		    	   this.add(Labels[i]);
		       }
			 
		       for (int i=0;i<n;i++) {
		    	   int x=rd.nextInt(300);
		    	   a[i]=x;
		    	   Labels[i].setText(""+x+ "("+ (i+1)+")"+ " ");
		    	   input.setText(input.getText()+x+ " ");
		       }
		      
		}
		if(e.getSource()==run ) {
			this.add(option_1);
			this.add(option_2);
		}
		if(e.getSource()==option_2 ) {
			checkOption=1;
			this.add(next);
			this.remove(option_1);
			this.remove(option_2);
			this.remove(title);
			for (int i=0;i<16;i++) {
		    	   Labels[i].setText("");
		       }
		    numbers = input.getText().split("\\s");
		    flag=1;
		 //   flag=1;
            int idx=0;
		    for (String nb : numbers) {
		    	   a[idx]=Integer.parseInt(nb);
		    	   idx++;
		    	  }
		    n=idx;
		    seconds=n;
		    for (int i=0;i<n;i++) {
		    	 Labels[i].setText(""+a[i]+ "("+ (i+1)+")"+ " ");
		    }
           index=0;

		  //  BITree=constructBITree(a,n);
		    for (int i=0;i<n;i++) {
            	int t=i+1;
            	updateBIT(BITree, n, i, a[i]);
         	    while (t <= n)
         	    {
         	    	c[index]=t;
         	    	
         	    	//System.out.println(c[index]);
        
         	    	add[index]=BITree[t];
         	    	t += t & (-t);
         	    	b[index]=i;
         	        index++;   
         	    	
         	    }
		    }
		    count=0;
		    timer.start();
		}
		if(e.getSource()==next ) {
			if (count<index) {
				if (turnon==1) {
					 exp2.setBounds(50,200,400,100);
					 exp1.setBounds(3000,200,400,100);
					 }
				  else {
					  exp2.setBounds(3000,200,400,100);
					  exp1.setBounds(3000,200,400,100);
					  exp3.setBounds(3000,200,400,100);
				  }
				  Labels[b[count]].setText(""+BITree[b[count]+1]);
				  Labels[b[count]].setForeground(Color.blue);
				  count++;
				  repaint();
			}
			else { flag=4;}
		}
		if(e.getSource()==option_1 ) {
			checkOption=0;
			this.add(stop);
			this.add(goback);
			this.remove(option_1);
			this.remove(option_2);
			this.remove(title);
			for (int i=0;i<16;i++) {
		    	   Labels[i].setText("");
		       }
		    numbers = input.getText().split("\\s");
		    flag=1;
		 //   flag=1;
            int idx=0;
		    for (String nb : numbers) {
		    	   a[idx]=Integer.parseInt(nb);
		    	   idx++;
		    	  }
		    n=idx;
		    seconds=n;
		    for (int i=0;i<n;i++) {
		    	 Labels[i].setText(""+a[i]+ "("+ (i+1)+")"+ " ");
		    }
           index=0;

		  //  BITree=constructBITree(a,n);
		    for (int i=0;i<n;i++) {
            	int t=i+1;
            	updateBIT(BITree, n, i, a[i]);
         	    while (t <= n)
         	    {
         	    	c[index]=t;
         	    	
         	    	//System.out.println(c[index]);
        
         	    	add[index]=BITree[t];
         	    	t += t & (-t);
         	    	b[index]=i;
         	        index++;   
         	    	
         	    }
		    }
		    timer.start();
		}
	}
	 
}
