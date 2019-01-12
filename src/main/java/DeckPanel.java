import javax.accessibility.Accessible;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;


/**
 * On créer à chaque tour un deck, qui prend en entrée la liste turnDeck qui est le deck associé au tour.
 */
public class DeckPanel extends JPanel {

    private Image image;
    DTPicture pic1;
    PictureTransferHandler picHandler;


    public DeckPanel(ArrayList<Domino> deck) {
        picHandler = new PictureTransferHandler();
        DTPicture.setInstallInputMapBindings(false);

        GridBagLayout containerLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        this.setLayout(containerLayout);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.weighty = 1;

        int i = 0;
        for (Domino domino: deck) {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.ipadx = 146;
            gbc.ipady = 62;
            try {
                image = ImageIO.read(new File(domino.getPathToImg()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            pic1 = new DTPicture(image);
            containerLayout.setConstraints(pic1, gbc);
            pic1.setTransferHandler(picHandler);
            this.add(pic1);
            i++;
        }
    }
}

class DTPicture extends Picture implements MouseMotionListener {
    private MouseEvent firstMouseEvent = null;

    private static boolean installInputMapBindings = true;

    public DTPicture(Image image) {
        super(image);
        addMouseMotionListener(this);

        //Add the cut/copy/paste key bindings to the input map.
        //Note that this step is redundant if you are installing
        //menu accelerators that cause these actions to be invoked.
        //DragPictureDemo does not use menu accelerators and, since
        //the default value of installInputMapBindings is true,
        //the bindings are installed. DragPictureDemo2 does use
        //menu accelerators and so calls setInstallInputMapBindings
        //with a value of false. Your program would do one or the
        //other, but not both.
        if (installInputMapBindings) {
            InputMap imap = this.getInputMap();
            imap.put(KeyStroke.getKeyStroke("ctrl X"), TransferHandler
                    .getCutAction().getValue(Action.NAME));
            imap.put(KeyStroke.getKeyStroke("ctrl C"), TransferHandler
                    .getCopyAction().getValue(Action.NAME));
            imap.put(KeyStroke.getKeyStroke("ctrl V"), TransferHandler
                    .getPasteAction().getValue(Action.NAME));
        }

        //Add the cut/copy/paste actions to the action map.
        //This step is necessary because the menu's action listener
        //looks for these actions to fire.
        ActionMap map = this.getActionMap();
        map.put(TransferHandler.getCutAction().getValue(Action.NAME),
                TransferHandler.getCutAction());
        map.put(TransferHandler.getCopyAction().getValue(Action.NAME),
                TransferHandler.getCopyAction());
        map.put(TransferHandler.getPasteAction().getValue(Action.NAME),
                TransferHandler.getPasteAction());
    }

    public void setImage(Image image) {
        this.image = image;
        this.repaint();
    }

    public void mousePressed(MouseEvent e) {
        //Don't bother to drag if there is no image.
        if (image == null)
            return;

        firstMouseEvent = e;
        e.consume();
    }

    public void mouseDragged(MouseEvent e) {
        //Don't bother to drag if the component displays no image.
        if (image == null)
            return;

        if (firstMouseEvent != null) {
            e.consume();

            //If they are holding down the control key, COPY rather than MOVE
            int ctrlMask = InputEvent.CTRL_DOWN_MASK;
            int action = ((e.getModifiersEx() & ctrlMask) == ctrlMask) ? TransferHandler.COPY
                    : TransferHandler.MOVE;

            int dx = Math.abs(e.getX() - firstMouseEvent.getX());
            int dy = Math.abs(e.getY() - firstMouseEvent.getY());
            //Arbitrarily define a 5-pixel shift as the
            //official beginning of a drag.
            if (dx > 5 || dy > 5) {
                //This is a drag, not a click.
                JComponent c = (JComponent) e.getSource();
                TransferHandler handler = c.getTransferHandler();
                //Tell the transfer handler to initiate the drag.
                handler.exportAsDrag(c, firstMouseEvent, action);
                firstMouseEvent = null;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        firstMouseEvent = null;
    }

    public void mouseMoved(MouseEvent e) {
    }

    //This method is necessary because DragPictureDemo and
    //DragPicturePictureTransferHandlerDemo2 both use this class and DragPictureDemo
    //needs to have the input map bindings installed for
    //cut/copy/paste. DragPictureDemo2 uses menu accelerators
    //and does not need to have the input map bindings installed.
    //Your program would use one approach or the other, but not
    //both. The default for installInputMapBindings is true.
    public static void setInstallInputMapBindings(boolean flag) {
        installInputMapBindings = flag;
    }

    public static boolean getInstallInputMapBindingds() { //for completeness
        return installInputMapBindings;
    }
}

/*
 * Picture.java is used by the 1.4 TrackFocusDemo.java and DragPictureDemo.java
 * examples.
 */

class Picture extends JComponent implements MouseListener, FocusListener,
        Accessible {
    Image image;

    public Picture(Image image) {

        this.image = image;
        setFocusable(true);
        addMouseListener(this);
        addFocusListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        //Since the user clicked on us, let's get focus!
        requestFocusInWindow();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void focusGained(FocusEvent e) {
        //Draw the component with a red border
        //indicating that it has focus.
        this.repaint();
    }

    public void focusLost(FocusEvent e) {
        //Draw the component with a black border
        //indicating that it doesn't have focus.
        this.repaint();
    }

    protected void paintComponent(Graphics graphics) {
        Graphics g = graphics.create();

        //Draw in our entire space, even if isOpaque is false.
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image == null ? 125 : image.getWidth(this),
                image == null ? 125 : image.getHeight(this));

        if (image != null) {
            //Draw image at its natural size of 125x125.
            g.drawImage(image, 0, 0, this);
        }

        //Add a border, red if picture currently has focus
        if (isFocusOwner()) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLACK);
        }
        g.drawRect(0, 0, image == null ? 125 : image.getWidth(this),
                image == null ? 125 : image.getHeight(this));
        g.dispose();
    }
}

/*
 * PictureTransferHandler.java is used by the 1.4 DragPictureDemo.java example.
 */

class PictureTransferHandler extends TransferHandler {
    DataFlavor pictureFlavor = DataFlavor.imageFlavor;

    DTPicture sourcePic;

    boolean shouldRemove;

    public boolean importData(JComponent c, Transferable t) {
        Image image;
        if (canImport(c, t.getTransferDataFlavors())) {
            DTPicture pic = (DTPicture) c;
            //Don't drop on myself.
            if (sourcePic == pic) {
                shouldRemove = false;
                return true;
            }
            try {
                image = (Image) t.getTransferData(pictureFlavor);
                //Set the component to the new picture.
                pic.setImage(image);
                return true;
            } catch (UnsupportedFlavorException ufe) {
                System.out.println("importData: unsupported data flavor");
            } catch (IOException ioe) {
                System.out.println("importData: I/O exception");
            }
        }
        return false;
    }

    protected Transferable createTransferable(JComponent c) {
        sourcePic = (DTPicture) c;
        shouldRemove = true;
        return new PictureTransferable(sourcePic);
    }

    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    protected void exportDone(JComponent c, Transferable data, int action) {
        if (shouldRemove && (action == MOVE)) {
            sourcePic.setImage(null);
        }
        sourcePic = null;
    }

    public boolean canImport(JComponent c, DataFlavor[] flavors) {
        for (int i = 0; i < flavors.length; i++) {
            if (pictureFlavor.equals(flavors[i])) {
                return true;
            }
        }
        return false;
    }

    class PictureTransferable implements Transferable {
        private Image image;

        PictureTransferable(DTPicture pic) {
            image = pic.image;
        }

        public Object getTransferData(DataFlavor flavor)
                throws UnsupportedFlavorException {
            if (!isDataFlavorSupported(flavor)) {
                throw new UnsupportedFlavorException(flavor);
            }
            return image;
        }

        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[] { pictureFlavor };
        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return pictureFlavor.equals(flavor);
        }
    }
}

