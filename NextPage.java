import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NextPage extends Template implements ActionListener
{
    JLabel label;
    JButton pack ;
    JButton unpack;

    NextPage(String value)
    {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        label = new JLabel("Welcome: "+value);
        Dimension size = label.getPreferredSize();
        label.setBounds(40,50, size.width + 60, size.height);
        label.setFont(new Font("Century",Font.BOLD,17));
        label.setForeground (Color.blue);

        pack=new JButton("Pack Files");
        Dimension bsize = pack.getPreferredSize();
        pack.setBounds(100,100, bsize.width, bsize.height);
        pack.addActionListener(this);

        unpack=new JButton("Unpack Files");
        Dimension b2size = unpack.getPreferredSize();
        unpack.setBounds(300,100, b2size.width, b2size.height);
        unpack.addActionListener(this);

        _header.add(label);
        _content.add(pack);
        _content.add(unpack);

        clockhome();
        this.setSize(600,600);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if ( ae.getSource().equals(exit))
        {
            this.setVisible(false);
            System.exit(0);
        }
        if (ae.getSource().equals(minimize) )
        {
            this.setState(this.ICONIFIED);
        }
        if (ae.getSource().equals(pack) )
        {
            this.setVisible(false);
            if (ae.getSource().equals(unpack))
            {
                this.setVisible(false);
            }
        }
    }
}
