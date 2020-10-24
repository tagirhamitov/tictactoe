package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons;
    private Button resetButton;
    private TextView textInfo;
    private int left;
    private boolean stopped = false;

    private void reset() {
        textInfo.setText("Your turn");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        stopped = false;
        left = 9;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new Button[3][3];
        buttons[0][0] = findViewById(R.id.button11);
        buttons[0][1] = findViewById(R.id.button12);
        buttons[0][2] = findViewById(R.id.button13);
        buttons[1][0] = findViewById(R.id.button21);
        buttons[1][1] = findViewById(R.id.button22);
        buttons[1][2] = findViewById(R.id.button23);
        buttons[2][0] = findViewById(R.id.button31);
        buttons[2][1] = findViewById(R.id.button32);
        buttons[2][2] = findViewById(R.id.button33);

        resetButton = findViewById(R.id.button_reset);
        textInfo = findViewById(R.id.text_info);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setOnClickListener(this);
            }
        }
        resetButton.setOnClickListener(this);

        reset();
    }

    @Override
    public void onClick(View v) {
        System.out.println(left);
        Button button = (Button) v;
        if (button == resetButton) {
            reset();
            return;
        }
        if (stopped || !button.getText().toString().equals("")) {
            return;
        }
        button.setText("X");
        left--;
        if (checkWinner("X")) {
            winPlayer("X");
            return;
        }
        if (left == 0) {
            winPlayer("");
        } else {
            computerMove();
            if(checkWinner("O")) {
                winPlayer("O");
                return;
            }
            if (left == 0) {
                winPlayer("");
            }
        }
    }

    private void computerMove() {
        left--;
        for (int i = 0; i < 3; i++) {
            int countO = 0;
            int countX = 0;
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().toString().equals("O")) {
                    countO++;
                } else if (buttons[i][j].getText().toString().equals("X")) {
                    countX++;
                }
            }
            if (countO == 2 && countX == 0) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText("O");
                }
                return;
            }
        }
        for (int j = 0; j < 3; j++) {
            int countO = 0;
            int countX = 0;
            for (int i = 0; i < 3; i++) {
                if (buttons[i][j].getText().toString().equals("O")) {
                    countO++;
                } else if (buttons[i][j].getText().toString().equals("X")) {
                    countX++;
                }
            }
            if (countO == 2 && countX == 0) {
                for (int i = 0; i < 3; i++) {
                    buttons[i][j].setText("O");
                }
                return;
            }
        }
        int countO = 0;
        int countX = 0;
        for (int i = 0; i < 3; i++) {
            if (buttons[i][i].getText().toString().equals("O")) {
                countO++;
            } else if (buttons[i][i].getText().toString().equals("X")) {
                countX++;
            }
        }
        if (countO == 2 && countX == 0) {
            for (int i = 0; i < 3; i++) {
                buttons[i][i].setText("O");
            }
            return;
        }
        countO = 0;
        countX = 0;
        for (int i = 0; i < 3; i++) {
            if (buttons[i][2 - i].getText().toString().equals("O")) {
                countO++;
            } else if (buttons[i][2 - i].getText().toString().equals("X")) {
                countX++;
            }
        }
        if (countO == 2 && countX == 0) {
            for (int i = 0; i < 3; i++) {
                buttons[i][2 - i].setText("O");
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            countO = 0;
            countX = 0;
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().toString().equals("O")) {
                    countO++;
                } else if (buttons[i][j].getText().toString().equals("X")) {
                    countX++;
                }
            }
            if (countO == 0 && countX == 2) {
                for (int j = 0; j < 3; j++) {
                    if (buttons[i][j].getText().toString().equals("")) {
                        buttons[i][j].setText("O");
                        break;
                    }
                }
                return;
            }
        }
        for (int j = 0; j < 3; j++) {
            countO = 0;
            countX = 0;
            for (int i = 0; i < 3; i++) {
                if (buttons[i][j].getText().toString().equals("O")) {
                    countO++;
                } else if (buttons[i][j].getText().toString().equals("X")) {
                    countX++;
                }
            }
            if (countO == 0 && countX == 2) {
                for (int i = 0; i < 3; i++) {
                    if (buttons[i][j].getText().toString().equals("")) {
                        buttons[i][j].setText("O");
                        break;
                    }
                }
                return;
            }
        }
        countO = 0;
        countX = 0;
        for (int i = 0; i < 3; i++) {
            if (buttons[i][i].getText().toString().equals("O")) {
                countO++;
            } else if (buttons[i][i].getText().toString().equals("X")) {
                countX++;
            }
        }
        if (countO == 0 && countX == 2) {
            for (int i = 0; i < 3; i++) {
                if (buttons[i][i].getText().toString().equals("")) {
                    buttons[i][i].setText("O");
                    break;
                }
            }
            return;
        }
        countO = 0;
        countX = 0;
        for (int i = 0; i < 3; i++) {
            if (buttons[i][2 - i].getText().toString().equals("O")) {
                countO++;
            } else if (buttons[i][2 - i].getText().toString().equals("X")) {
                countX++;
            }
        }
        if (countO == 2 && countX == 0) {
            for (int i = 0; i < 3; i++) {
                if (buttons[i][2 - i].getText().toString().equals("")) {
                    buttons[i][2 - i].setText("O");
                    break;
                }
            }
            return;
        }
        Random random = new Random();
        int n = random.nextInt(left);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().toString().equals("")) {
                    if (n == 0) {
                        buttons[i][j].setText("O");
                        return;
                    } else {
                        n--;
                    }
                }
            }
        }
    }

    private boolean checkWinner(String player) {
        boolean win = false;
        for (int i = 0; i < 3; i++) {
            boolean winRow = true;
            for (int j = 0; j < 3; j++) {
                if (!buttons[i][j].getText().toString().equals(player)) {
                    winRow = false;
                    break;
                }
            }
            if (winRow) {
                win = true;
                break;
            }
        }
        for (int j = 0; j < 3; j++) {
            boolean winCol = true;
            for (int i = 0; i < 3; i++) {
                if (!buttons[i][j].getText().toString().equals(player)) {
                    winCol = false;
                    break;
                }
            }
            if (winCol) {
                win = true;
                break;
            }
        }
        boolean winDiag = true;
        for (int i = 0; i < 3; i++) {
            if (!buttons[i][i].getText().toString().equals(player)) {
                winDiag = false;
                break;
            }
        }
        if (winDiag) {
            win = true;
        }
        winDiag = true;
        for (int i = 0; i < 3; i++) {
            if (!buttons[i][2 - i].getText().toString().equals(player)) {
                winDiag = false;
                break;
            }
        }
        if (winDiag) {
            win = true;
        }
        return win;
    }

    private void winPlayer(String player) {
        if (player.equals("X")) {
            textInfo.setText("You win!");
        } else if (player.equals("O")) {
            textInfo.setText("You lose :(");
        } else {
            textInfo.setText("Draw");
        }
        stopped = true;
    }

}