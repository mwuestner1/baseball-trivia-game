/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sports.game;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author mattw
 */

public class Main extends javax.swing.JFrame {
    
    private int question;
    private int chances;
    private int score;
    private final int receive;
    private int reply;
    
    Connection conn = null;
    PreparedStatement pst = null;
     
    /**
     * This method ends game.
     */
    private void gameOver() {
        if (chances == 0 || question == 5) {
            invisible();
            JOptionPane.showMessageDialog(null, "Congrats! You finished with " + String.valueOf(score), "Game Over", JOptionPane.INFORMATION_MESSAGE);
                
            String sql = "INSERT INTO scores (user_id, points, chances) VALUES (?, ?, ?)";
                
            try {
               
                pst = conn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(player_field.getText()));
                pst.setInt(2, Integer.parseInt(score_field.getText()));
                pst.setInt(3, Integer.parseInt(chances_field.getText()));
                pst.execute();
                             
                } catch (NumberFormatException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        pst.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                Scores scores = new Scores();
                scores.setVisible(true);
                this.dispose();
        }
    }
    
    /**
     * This method adds points to the score.
     */
    private void receivePoints() {
        score += receive;
        score_field.setText(String.valueOf(score));
    }
    
    /**
     * This method subtracts chances.
     */
    private void loseChances() {
        chances--;
        chances_field.setText(String.valueOf(chances));
    }
    
    /**
     * Sets all choice fields to invisible.
     */
    private void invisible() {
        choice1_field.setVisible(false);
        choice2_field.setVisible(false);
        choice3_field.setVisible(false);
        choice4_field.setVisible(false);
    }
    
    /**
     * Sets all choice fields to visible.
     */
    private void visible() {
        choice1_field.setVisible(true);
        choice2_field.setVisible(true);
        choice3_field.setVisible(true);
        choice4_field.setVisible(true);
    }
    
    /**
     * Sets all choice fields to red background.
     */
    private void red() {
        choice1_field.setBackground(Color.red);
        choice2_field.setBackground(Color.red);
        choice3_field.setBackground(Color.red);
        choice4_field.setBackground(Color.red);
    }
    
    /**
     * Occurs if wrong answer chosen.
     */
    private void wrong() {
        JOptionPane.showMessageDialog(null, "Wrong!", "Wrong Answer", JOptionPane.ERROR_MESSAGE);
        loseChances();
        invisible();
        gameOver();
    }
    
    /**
     * Occurs if right answer chosen.
     */
    private void right() {
        JOptionPane.showMessageDialog(null, "Great Job! You received " + String.valueOf(receive), "Correct Answer", JOptionPane.INFORMATION_MESSAGE);
        receivePoints();
        invisible();
        gameOver();
    }

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        chances = 2;
        score = 0;
        receive = 20;
        question = 0;
        conn = Database.java_db();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        question_field = new javax.swing.JTextField();
        choice1_field = new javax.swing.JTextField();
        choice2_field = new javax.swing.JTextField();
        choice3_field = new javax.swing.JTextField();
        choice4_field = new javax.swing.JTextField();
        begin_btn = new javax.swing.JButton();
        player_field = new javax.swing.JTextField();
        player_label = new javax.swing.JLabel();
        chances_label = new javax.swing.JLabel();
        chances_field = new javax.swing.JTextField();
        score_label = new javax.swing.JLabel();
        score_field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        question_field.setEditable(false);
        question_field.setBackground(java.awt.Color.red);
        question_field.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        question_field.setForeground(new java.awt.Color(255, 255, 255));
        question_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        question_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        question_field.setPreferredSize(new java.awt.Dimension(600, 60));

        choice1_field.setEditable(false);
        choice1_field.setBackground(java.awt.Color.red);
        choice1_field.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        choice1_field.setForeground(new java.awt.Color(255, 255, 255));
        choice1_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        choice1_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        choice1_field.setPreferredSize(new java.awt.Dimension(210, 60));
        choice1_field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choice1_fieldMouseClicked(evt);
            }
        });

        choice2_field.setEditable(false);
        choice2_field.setBackground(java.awt.Color.red);
        choice2_field.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        choice2_field.setForeground(new java.awt.Color(255, 255, 255));
        choice2_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        choice2_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        choice2_field.setPreferredSize(new java.awt.Dimension(210, 60));
        choice2_field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choice2_fieldMouseClicked(evt);
            }
        });

        choice3_field.setEditable(false);
        choice3_field.setBackground(java.awt.Color.red);
        choice3_field.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        choice3_field.setForeground(new java.awt.Color(255, 255, 255));
        choice3_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        choice3_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        choice3_field.setPreferredSize(new java.awt.Dimension(210, 60));
        choice3_field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choice3_fieldMouseClicked(evt);
            }
        });

        choice4_field.setEditable(false);
        choice4_field.setBackground(java.awt.Color.red);
        choice4_field.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        choice4_field.setForeground(new java.awt.Color(255, 255, 255));
        choice4_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        choice4_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        choice4_field.setPreferredSize(new java.awt.Dimension(210, 60));
        choice4_field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choice4_fieldMouseClicked(evt);
            }
        });

        begin_btn.setForeground(java.awt.Color.red);
        begin_btn.setText("BEGIN");
        begin_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                begin_btnMouseClicked(evt);
            }
        });

        player_field.setEditable(false);
        player_field.setBackground(java.awt.Color.red);
        player_field.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        player_field.setForeground(new java.awt.Color(255, 255, 255));
        player_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        player_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        player_field.setPreferredSize(new java.awt.Dimension(70, 31));

        player_label.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        player_label.setForeground(new java.awt.Color(255, 255, 255));
        player_label.setText("Player:");

        chances_label.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        chances_label.setForeground(new java.awt.Color(255, 255, 255));
        chances_label.setText("Chances:");

        chances_field.setEditable(false);
        chances_field.setBackground(java.awt.Color.red);
        chances_field.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        chances_field.setForeground(new java.awt.Color(255, 255, 255));
        chances_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        chances_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        chances_field.setPreferredSize(new java.awt.Dimension(70, 31));

        score_label.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        score_label.setForeground(new java.awt.Color(255, 255, 255));
        score_label.setText("Score:");

        score_field.setEditable(false);
        score_field.setBackground(java.awt.Color.red);
        score_field.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        score_field.setForeground(new java.awt.Color(255, 255, 255));
        score_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        score_field.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        score_field.setPreferredSize(new java.awt.Dimension(70, 31));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(question_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(choice1_field, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(choice2_field, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(choice3_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(choice4_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(player_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(player_field, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(chances_label)
                                .addGap(18, 18, 18)
                                .addComponent(chances_field, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(score_label)
                                .addGap(18, 18, 18)
                                .addComponent(score_field, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(begin_btn)
                        .addGap(388, 388, 388))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player_label)
                    .addComponent(chances_label)
                    .addComponent(chances_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(score_label)
                    .addComponent(score_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(question_field, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choice1_field, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice3_field, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choice2_field, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice4_field, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(begin_btn)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        this.getContentPane().setBackground(Color.red);
    }//GEN-LAST:event_formMouseMoved

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        if (question == 0) {
        question_field.setText("Are You a True Cardinals Fan?");
        player_field.setText(String.valueOf(User.userId));
        chances_field.setText(String.valueOf(chances));
        score_field.setText(String.valueOf(score));
        }
    }//GEN-LAST:event_formWindowActivated

    private void begin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_begin_btnMouseClicked
        
        begin_btn.setText("Continue");
        question++;
        visible();
        red();
        
        if (question == 1) {
            question_field.setText("Who is the catcher for the Cardinals?");
            choice1_field.setText("A) Buster Posey");
            choice2_field.setText("B) Yadier Molina");
            choice3_field.setText("C) Salvador Perez");
            choice4_field.setText("D) J.T. Realmuto");
        }
        
        if (question == 2) {
            question_field.setText("How many consecutive Gold Gloves did Ozzie Smith earn?");
            choice1_field.setText("A) 3");
            choice2_field.setText("B) 6");
            choice3_field.setText("C) 13");
            choice4_field.setText("D) 15");
        }
        
        if (question == 3) {
            question_field.setText("In what year did the Cardinals win their first World Series?");
            choice1_field.setText("A) 1922");
            choice2_field.setText("B) 1926");
            choice3_field.setText("C) 1945");
            choice4_field.setText("D) 1957");
        }
        
        if (question == 4) {
            question_field.setText("What was Bob Gibson's best single season ERA?");
            choice1_field.setText("A) 1.12");
            choice2_field.setText("B) 2.18");
            choice3_field.setText("C) 2.44");
            choice4_field.setText("D) 2.46");
        }
        
        if (question == 5) {
            question_field.setText("Which Cardinal was known as 'Big Mac'?");
            choice1_field.setText("A) Mark McGuire");
            choice2_field.setText("B) Jim Edmonds");
            choice3_field.setText("C) Albert Pujols");
            choice4_field.setText("D) Scott Rolen");
        }
    }//GEN-LAST:event_begin_btnMouseClicked

    private void choice1_fieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choice1_fieldMouseClicked
        
        if (question == 1) {
            choice1_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice1_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 2) {
            choice1_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice1_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 3) {
            choice1_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice1_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 4) {
            choice1_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice1_field.setBackground(Color.green);
                right();
            } else {
                red();
            }
        }
        
        if (question == 5) {
            choice1_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice1_field.setBackground(Color.green);
                right();
            } else {
                red();
            }
        }
    }//GEN-LAST:event_choice1_fieldMouseClicked

    private void choice3_fieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choice3_fieldMouseClicked
        if (question == 1) {
            choice3_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice3_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 2) {
            choice3_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice3_field.setBackground(Color.green);
                right();
            } else {
                red();
            }
        }
        
        if (question == 3) {
            choice3_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice3_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 4) {
            choice3_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice3_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 5) {
            choice3_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice3_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
    }//GEN-LAST:event_choice3_fieldMouseClicked

    private void choice2_fieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choice2_fieldMouseClicked
        if (question == 1) {
            choice2_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice2_field.setBackground(Color.green);
                right();
            } else {
                red();
            }
        }
        
        if (question == 2) {
            choice2_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice2_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 3) {
            choice2_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice2_field.setBackground(Color.green);
                right();
            } else {
                red();
            }
        }
        
        if (question == 4) {
            choice2_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice2_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 5) {
            choice2_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice2_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
    }//GEN-LAST:event_choice2_fieldMouseClicked

    private void choice4_fieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choice4_fieldMouseClicked
        if (question == 1) {
            choice4_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice4_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 2) {
            choice4_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice4_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 3) {
            choice4_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice4_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 4) {
            choice4_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice4_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
        
        if (question == 5) {
            choice4_field.setBackground(Color.darkGray);
            reply = JOptionPane.showConfirmDialog(null, "Are you sure?", "Just Checking", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                choice4_field.setVisible(false);
                wrong();
            } else {
                red();
            }
        }
    }//GEN-LAST:event_choice4_fieldMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton begin_btn;
    private javax.swing.JTextField chances_field;
    private javax.swing.JLabel chances_label;
    private javax.swing.JTextField choice1_field;
    private javax.swing.JTextField choice2_field;
    private javax.swing.JTextField choice3_field;
    private javax.swing.JTextField choice4_field;
    private javax.swing.JTextField player_field;
    private javax.swing.JLabel player_label;
    private javax.swing.JTextField question_field;
    private javax.swing.JTextField score_field;
    private javax.swing.JLabel score_label;
    // End of variables declaration//GEN-END:variables
}
