import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class relevant to GUI
 */
public class GUI extends JFrame implements ActionListener {

    ArrayList<String> answers = new ArrayList<>();
    int questionCounter = 0;

    /**
     * Generate GUI
     * @param title name of the GUI's title
     */
    public GUI(String title) {
        super(title);

        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Initialise components
     */
    private void initComponents() {
        topPanel = new javax.swing.JPanel();
        centerPanel = new javax.swing.JPanel();
        homePage = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        fileLabel = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        startBtn = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        inputPage = new javax.swing.JPanel();
        questionNumberLabel = new javax.swing.JLabel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 200));
        questionLabel = new javax.swing.JLabel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        answerComboBox = new javax.swing.JComboBox<>();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        nextBtn = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        resultPage = new javax.swing.JPanel();
        resultTitleLabel = new javax.swing.JLabel();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 200));
        resultLabel = new javax.swing.JLabel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        doneBtn = new javax.swing.JButton();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        bottomPanel = new javax.swing.JPanel();
        settingsBtn = new javax.swing.JButton();
        authorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(2160, 1400));
        setMinimumSize(new java.awt.Dimension(1080, 700));
        setPreferredSize(new java.awt.Dimension(1080, 720));

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
                topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1080, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
                topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(topPanel, java.awt.BorderLayout.NORTH);

        centerPanel.setLayout(new java.awt.CardLayout());

        homePage.setLayout(new javax.swing.BoxLayout(homePage, javax.swing.BoxLayout.Y_AXIS));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleLabel.setText("Naive Bayes Prediction");
        titleLabel.setAlignmentX(0.5F);
        homePage.add(titleLabel);
        homePage.add(filler1);

        fileLabel.setText("Trained Data Set: " + Control.ML.file);
        fileLabel.setAlignmentX(0.5F);
        homePage.add(fileLabel);

        homePage.add(filler3);

        startBtn.setText("Start");
        startBtn.setAlignmentX(0.5F);
        homePage.add(startBtn);
        homePage.add(filler2);

        centerPanel.add(homePage, "card2");

        inputPage.setLayout(new javax.swing.BoxLayout(inputPage, javax.swing.BoxLayout.Y_AXIS));

        questionNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        questionNumberLabel.setText("Question #1");
        questionNumberLabel.setAlignmentX(0.5F);
        inputPage.add(questionNumberLabel);
        inputPage.add(filler5);

        questionLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        questionLabel.setText("Question");
        questionLabel.setAlignmentX(0.5F);
        inputPage.add(questionLabel);
        inputPage.add(filler7);

        answerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        answerComboBox.setMaximumSize(new java.awt.Dimension(400, 50));
        answerComboBox.setMinimumSize(new java.awt.Dimension(72, 50));
        answerComboBox.setPreferredSize(new java.awt.Dimension(72, 50));
        inputPage.add(answerComboBox);
        inputPage.add(filler4);

        nextBtn.setText("Next Question");
        nextBtn.setAlignmentX(0.5F);
        inputPage.add(nextBtn);
        inputPage.add(filler6);

        centerPanel.add(inputPage, "card3");

        resultPage.setLayout(new javax.swing.BoxLayout(resultPage, javax.swing.BoxLayout.Y_AXIS));

        resultTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        resultTitleLabel.setText("Prediction Result");
        resultTitleLabel.setAlignmentX(0.5F);
        resultPage.add(resultTitleLabel);
        resultPage.add(filler8);

        resultLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resultLabel.setText("Result %");
        resultLabel.setAlignmentX(0.5F);
        resultPage.add(resultLabel);
        resultPage.add(filler9);
        resultPage.add(filler10);

        doneBtn.setText("Done");
        doneBtn.setAlignmentX(0.5F);

        resultPage.add(doneBtn);
        resultPage.add(filler11);

        centerPanel.add(resultPage, "card4");

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        settingsBtn.setText("Settings");
        settingsBtn.setAlignmentX(0.5F);

        authorLabel.setText("D21125387");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
                bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 854, Short.MAX_VALUE)
                                .addComponent(settingsBtn)
                                .addGap(27, 27, 27))
        );
        bottomPanelLayout.setVerticalGroup(
                bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bottomPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(settingsBtn)
                                        .addComponent(authorLabel))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        startBtn.addActionListener(this);
        settingsBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        doneBtn.addActionListener(this);
        answerComboBox.addActionListener(this);

        pack();
    }

    private javax.swing.JComboBox<String> answerComboBox;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton doneBtn;
    private javax.swing.JLabel fileLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JPanel homePage;
    private javax.swing.JPanel inputPage;
    private javax.swing.JButton nextBtn;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionNumberLabel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JPanel resultPage;
    private javax.swing.JLabel resultTitleLabel;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel topPanel;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (startBtn.equals(e.getSource())) {
            goToPage(inputPage);
            settingsBtn.setVisible(false);
            questionHandler();
        }

        if (settingsBtn.equals(e.getSource())){
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();

                System.out.println(selectedFile.getAbsolutePath());
                Control.ML.setFileName(selectedFile.getAbsolutePath());
                Control.ML.open();
                Control.ML.transformData();
                Control.ML.observeData();
                fileLabel.setText("Trained Data Set: " + selectedFile.getName());
                Control.MLTest.setFileName(selectedFile.getAbsolutePath());
                Control.MLTest.open();
                Control.MLTest.transformData();
                Control.MLTest.observeData();
                Control.MLTest.testFromPercentage(30);

                goToPage(homePage);
            }
        }

        if (nextBtn.equals(e.getSource())){
            if(nextBtn.getText().equals("Predict")){
                // if no more questions
                goToPage(resultPage);
                questionCounter = 0;
                nextBtn.setText("Next Question");
                answers.add((String) answerComboBox.getSelectedItem());
                System.out.println(answers);
                resultHandler();
                return;
            }

            answers.add((String) answerComboBox.getSelectedItem());
            questionHandler();
            System.out.println(answers);
        }

        if (doneBtn.equals(e.getSource())){
            goToPage(homePage);
            settingsBtn.setVisible(true);
        }
    }

    public void goToPage(JPanel page){
        centerPanel.removeAll();
        centerPanel.add(page);
        centerPanel.repaint();
        centerPanel.revalidate();
    }

    public void questionHandler(){
        if(questionCounter == Control.ML.getX()-2){
            nextBtn.setText("Predict");
        }

        questionNumberLabel.setText("Question #" + (questionCounter+1));
        questionLabel.setText(Control.ML.feature.get(questionCounter));
        List<String> combolist = new ArrayList<>();
        for (int i = 0; i < Control.ML.getFeatureCategory(questionCounter).size(); i++) {
            combolist.add(Control.ML.getFeatureCategoryKey(questionCounter).get(i));
        }
        Collections.sort(combolist);
        answerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(combolist.toArray(new String[0])));
        questionCounter++;
    }

    public void resultHandler(){
        resultLabel.setText("Result: " + Control.ML.applyEquationOpt(answers));
        questionCounter = 0;
        answers.clear();
    }
}
