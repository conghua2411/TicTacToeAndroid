package com.funnything.hoangcong.tic_tac_toe.tic_tac_toe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private bot dumb;
    private gameBoard game;
    private TextView tv_player_1_score;
    private TextView tv_player_2_score;
    private Button btn_reset;
    private Button btn_00;
    private Button btn_01;
    private Button btn_02;
    private Button btn_10;
    private Button btn_11;
    private Button btn_12;
    private Button btn_20;
    private Button btn_21;
    private Button btn_22;
    private String turn;
    private AlertDialog.Builder showWinner;
    private Integer p1_score;
    private Integer p2_score;
    private int gameOver; // 1 p1 win ,0: draw , -1: p2win

    private void reset() {
        game.reset();
        btn_00.setText("");
        btn_01.setText("");
        btn_02.setText("");
        btn_10.setText("");
        btn_11.setText("");
        btn_12.setText("");
        btn_20.setText("");
        btn_21.setText("");
        btn_22.setText("");
        turn = "X";
        gameOver = -2;
    }

    private void update_score() {
        if (gameOver == 1) {
            p1_score++;
//            tv_player_1_score.setText(String.format("Player 1 : %d", p1_score));
            tv_player_1_score.setText(String.format("Player : %d", p1_score));
        } else if (gameOver == -1) {
            p2_score++;
//            tv_player_2_score.setText(String.format("Player 2 : %d", p2_score));
            tv_player_2_score.setText(String.format("Bot : %d", p2_score));
        }
    }

    private void btnTextOnGame() {
        if(!game.board[0][0].equals("")) {
            btn_00.setText(game.board[0][0]);
        }
        if(!game.board[0][1].equals("")) {
            btn_01.setText(game.board[0][1]);
        }
        if(!game.board[0][2].equals("")) {
            btn_02.setText(game.board[0][2]);
        }
        if(!game.board[1][0].equals("")) {
            btn_10.setText(game.board[1][0]);
        }
        if(!game.board[1][1].equals("")) {
            btn_11.setText(game.board[1][1]);
        }
        if(!game.board[1][2].equals("")) {
            btn_12.setText(game.board[1][2]);
        }
        if(!game.board[2][0].equals("")) {
            btn_20.setText(game.board[2][0]);
        }
        if(!game.board[2][1].equals("")) {
            btn_21.setText(game.board[2][1]);
        }
        if(!game.board[2][2].equals("")) {
            btn_22.setText(game.board[2][2]);
        }
    }

    private void checkGameWin() {
        if (gameOver != -2) {
            if (gameOver == 1) {
//                showWinner.setMessage("Player 1 win");
                showWinner.setMessage(tv_player_1_score.getText().toString().substring(0,6) + " win");
            } else if (gameOver == -1) {
//                showWinner.setMessage("Player 2 win");
                showWinner.setMessage(tv_player_2_score.getText().toString().substring(0,3) + " win");
            } else if (gameOver == 0) {
                showWinner.setMessage("Draw");
            }
            showWinner.create().show();
        }

        update_score();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });


        btn_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn_00.getText().toString().equals("") && gameOver == -2) {

                    btn_00.setText(turn);
                    game.setPos(0, 0, turn);


                    gameOver = game.checkWin();
                    checkGameWin();

                    // 1 player
                    if(gameOver == -2) {
                        int[] botMove = dumb.makeMove(game);
                        if (gameOver != 0) {
                            game.setPos(botMove[0], botMove[1], "O");
                        }

                        gameOver = game.checkWin();
                        btnTextOnGame();
                        checkGameWin();

                        // 2 player
                        //changeTurn();
                    }
                }
            }
        });

        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_01.getText().toString().equals("") && gameOver == -2) {
                    btn_01.setText(turn);
                    game.setPos(0, 1, turn);


                    gameOver = game.checkWin();
                    checkGameWin();
                    // 1 player
                    if(gameOver == -2) {
                        int[] botMove = dumb.makeMove(game);

                        if (gameOver != 0) {
                            game.setPos(botMove[0], botMove[1], "O");
                        }

                        gameOver = game.checkWin();
                        btnTextOnGame();
                        checkGameWin();

                        // 2 player
                        //changeTurn();
                    }
                }
            }
        });

        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_02.getText().toString().equals("") && gameOver == -2) {
                    game.setPos(0, 2, turn);
                    btn_02.setText(turn);


                    gameOver = game.checkWin();
                    checkGameWin();

                    // 1 player
                    if(gameOver == -2) {
                        int[] botMove = dumb.makeMove(game);

                        if (gameOver != 0) {
                            game.setPos(botMove[0], botMove[1], "O");
                        }

                        gameOver = game.checkWin();
                        btnTextOnGame();
                        checkGameWin();

                        // 2 player
                        //changeTurn();
                    }
                }
            }
        });

        btn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_10.getText().toString().equals("") && gameOver == -2) {
                    game.setPos(1, 0, turn);
                    btn_10.setText(turn);


                    gameOver = game.checkWin();
                    checkGameWin();
                    // 1 player
                    if(gameOver == -2) {
                        int[] botMove = dumb.makeMove(game);

                        if (gameOver != 0) {
                            game.setPos(botMove[0], botMove[1], "O");
                        }

                        gameOver = game.checkWin();
                        btnTextOnGame();

                        checkGameWin();

                        // 2 player
                        //changeTurn();
                    }
                }
            }
        });

        btn_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_11.getText().toString().equals("") && gameOver == -2) {
                    game.setPos(1, 1, turn);
                    btn_11.setText(turn);


                    gameOver = game.checkWin();
                    checkGameWin();

                    // 1 player
                    if(gameOver == -2) {
                        int[] botMove = dumb.makeMove(game);

                        if (gameOver != 0) {
                            game.setPos(botMove[0], botMove[1], "O");
                        }

                        gameOver = game.checkWin();
                        btnTextOnGame();
                        checkGameWin();

                        // 2 player
                        //changeTurn();
                    }
                }
            }
        });

        btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_12.getText().toString().equals("") && gameOver == -2) {
                    game.setPos(1, 2, turn);
                    btn_12.setText(turn);


                    gameOver = game.checkWin();
                    checkGameWin();

                    // 1 player
                    if(gameOver == -2) {
                        int[] botMove = dumb.makeMove(game);

                        if (gameOver != 0) {
                            game.setPos(botMove[0], botMove[1], "O");
                        }

                        gameOver = game.checkWin();
                        btnTextOnGame();
                        checkGameWin();

                        // 2 player
                        //changeTurn();
                    }
                }

            }
        });

        btn_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_20.getText().toString().equals("") && gameOver == -2) {
                    game.setPos(2, 0, turn);
                    btn_20.setText(turn);


                    gameOver = game.checkWin();
                    checkGameWin();

                    // 1 player
                    if(gameOver == -2) {
                        int[] botMove = dumb.makeMove(game);

                        if (gameOver != 0) {
                            game.setPos(botMove[0], botMove[1], "O");
                        }

                        gameOver = game.checkWin();
                        btnTextOnGame();
                        checkGameWin();

                        // 2 player
                        //changeTurn();
                    }
                }
            }
        });

        btn_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_21.getText().toString().equals("") && gameOver == -2) {
                    game.setPos(2, 1, turn);
                    btn_21.setText(turn);


                    gameOver = game.checkWin();
                    checkGameWin();

                    // 1 player
                    if(gameOver == -2) {
                        int[] botMove = dumb.makeMove(game);

                        if (gameOver != 0) {
                            game.setPos(botMove[0], botMove[1], "O");
                        }

                        gameOver = game.checkWin();
                        btnTextOnGame();
                        checkGameWin();

                        // 2 player
                        //changeTurn();
                    }
                }
            }
        });

        btn_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_22.getText().toString().equals("") && gameOver == -2) {
                    game.setPos(2, 2, turn);
                    btn_22.setText(turn);


                    gameOver = game.checkWin();
                    checkGameWin();

                    // 1 player
                    if(gameOver == -2) {
                        int[] botMove = dumb.makeMove(game);

                        if (gameOver != 0) {
                            game.setPos(botMove[0], botMove[1], "O");
                        }

                        gameOver = game.checkWin();
                        btnTextOnGame();
                        checkGameWin();

                        // 2 player
                        //changeTurn();
                    }
                }
            }
        });
    }

    private void setup() {
        game = new gameBoard();
        tv_player_1_score = findViewById(R.id.text_view_p1);
        tv_player_2_score = findViewById(R.id.text_view_p2);
        p1_score = 0;
        p2_score = 0;

        dumb = new bot();

//        tv_player_1_score.setText(String.format("Player 1 : %d", p1_score));
//        tv_player_2_score.setText(String.format("Player 2 : %d", p2_score));
        tv_player_1_score.setText(String.format("Player : %d", p1_score));
        tv_player_2_score.setText(String.format("Bot : %d", p2_score));

        btn_reset = findViewById(R.id.btn_reset);
        btn_00 = findViewById(R.id.btn_00);
        btn_01 = findViewById(R.id.btn_01);
        btn_02 = findViewById(R.id.btn_02);
        btn_10 = findViewById(R.id.btn_10);
        btn_11 = findViewById(R.id.btn_11);
        btn_12 = findViewById(R.id.btn_12);
        btn_20 = findViewById(R.id.btn_20);
        btn_21 = findViewById(R.id.btn_21);
        btn_22 = findViewById(R.id.btn_22);
        turn = "X";
        showWinner = new AlertDialog.Builder(this);
        showWinner.setTitle("Result");
        showWinner.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                reset();
            }
        });
        showWinner.setNegativeButton(R.string.dialog_cancel, null);
        gameOver = game.checkWin();
    }

    private void changeTurn() {
        if (turn.equals("X")) {
            turn = "O";
        } else if (turn.equals("O")) {
            turn = "X";
        }
    }
}
