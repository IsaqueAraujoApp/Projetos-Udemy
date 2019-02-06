package com.cursoandroid.passaroamarelo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class FlappyBird extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture[] passaros;
	private Texture fundo;
	private Texture canoBaixo;
	private Texture canoTopo;
	private Texture gameOver;
	private Random numeroRandomico;
	private BitmapFont fonte;
	private BitmapFont mensagem;
	private BitmapFont score;
	private BitmapFont highscore;
	private BitmapFont inicio;
	private Circle passaroCirculo;
	private Rectangle retanguloCanoTopo;
	private Rectangle retanguloCanoBaixo;
	private boolean intersticial = false;
	//private ShapeRenderer shape;

	//Atributos de configuracao
	private float larguraDispositivo;
	private float alturaDispositivo;
	private int estadoJogo=0;// 0-> jogo não iniciado 1-> jogo iniciado 2-> Game Over
	private int pontuacao=0;

	private float variacao = 0;
	private float velocidadeQueda=0;
	private float posicaoInicialVertical;
	private float posicaoMovimentoCanoHorizontal;
	private float espacoEntreCanos;
	private float deltaTime;
	private float alturaEntreCanosRandomica;
	private boolean marcouPonto=false;
	private float velocidade = 0;

	//Câmera
	private OrthographicCamera camera;
	private Viewport viewport;
	private final float VIRTUAL_WIDTH = 768;
	private final float VIRTUAL_HEIGHT = 1024;
	private  Preferences prefs;
	private int prefshighscore = 0;
	private boolean comecou = false;
	@Override
	public void create () {
		prefs = Gdx.app.getPreferences("Flappy");
		prefshighscore = prefs.getInteger("valor",0);
		batch = new SpriteBatch();
		numeroRandomico = new Random();
		passaroCirculo = new Circle();
        /*retanguloCanoTopo = new Rectangle();
        retanguloCanoBaixo = new Rectangle();
        shape = new ShapeRenderer();*/
		fonte = new BitmapFont();
		fonte.setColor(Color.WHITE);
		fonte.getData().setScale(6);
		inicio = new BitmapFont();
		inicio.setColor(Color.WHITE);
		inicio.getData().setScale(5);
		mensagem = new BitmapFont();
		mensagem.setColor(Color.WHITE);
		mensagem.getData().setScale(4);
		score = new BitmapFont();
		score.setColor(Color.WHITE);
		score.getData().setScale(3);
		highscore = new BitmapFont();
		highscore.setColor(Color.WHITE);
		highscore.getData().setScale(3);
		passaros = new Texture[4];
		passaros[0] = new Texture("frame1.png");
		passaros[1] = new Texture("frame2.png");
		passaros[2] = new Texture("frame3.png");
		passaros[3] = new Texture("frame4.png");
		fundo = new Texture("fundo.png");
		canoBaixo = new Texture("cano_baixo.png");
		canoTopo = new Texture("cano_topo.png");
		gameOver = new Texture("game_over.png");

		/**********************************************
		 * Configuração da câmera
		 * */
		camera = new OrthographicCamera();
		camera.position.set(VIRTUAL_WIDTH/2,VIRTUAL_HEIGHT/2, 0);
		viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);

		larguraDispositivo = VIRTUAL_WIDTH;
		alturaDispositivo  = VIRTUAL_HEIGHT;

		posicaoInicialVertical = alturaDispositivo / 2;
		posicaoMovimentoCanoHorizontal = larguraDispositivo;
		espacoEntreCanos = 300;

	}

	@Override
	public void render () {

		camera.update();

		// Limpar frames anteriores
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		deltaTime = Gdx.graphics.getDeltaTime();
		variacao += deltaTime * 10;
		if (variacao > 3) variacao = 0;

		if( estadoJogo == 0 ){
			intersticial = false;
			comecou = false;
			//Não iniciado
			if( Gdx.input.justTouched() ){
				comecou = true;
				estadoJogo = 1;
			}

		}else {//Iniciado
			velocidade+= 0.05;
			velocidadeQueda++;
			if (posicaoInicialVertical > 0 || velocidadeQueda < 0)
				posicaoInicialVertical = posicaoInicialVertical - velocidadeQueda;

			if( estadoJogo == 1 ){//iniciado

				posicaoMovimentoCanoHorizontal -= deltaTime * (200+velocidade);

				if (Gdx.input.justTouched()) {
					velocidadeQueda = -15;
				}

				//Verifica se o cano saiu inteiramente da tela
				if (posicaoMovimentoCanoHorizontal < -canoTopo.getWidth()) {
					posicaoMovimentoCanoHorizontal = larguraDispositivo;
					alturaEntreCanosRandomica = numeroRandomico.nextInt(400) - 200;
					marcouPonto = false;
				}

				//Verifica pontuação
				if(posicaoMovimentoCanoHorizontal < 120 ){
					if( !marcouPonto ){
						pontuacao++;
						marcouPonto = true;
					}
				}

			}else{// Game Over
				//Zerar o valores padrões
				if( Gdx.input.justTouched() ){
					estadoJogo = 0;
					velocidadeQueda = 0;
					velocidade = 0;
					pontuacao = 0;
					marcouPonto = false;
					posicaoMovimentoCanoHorizontal = larguraDispositivo;
					posicaoInicialVertical = alturaDispositivo / 2;
				}

			}


		}

		//Configurar dados de projeção da câmera
		batch.setProjectionMatrix( camera.combined );

		batch.begin();
		//Não iniciado

		batch.draw(fundo, 0, 0, larguraDispositivo, alturaDispositivo);
		batch.draw(canoTopo, posicaoMovimentoCanoHorizontal, alturaDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica);
		batch.draw(canoBaixo, posicaoMovimentoCanoHorizontal, alturaDispositivo / 2 - canoBaixo.getHeight() - espacoEntreCanos / 2 + alturaEntreCanosRandomica);
		batch.draw(passaros[(int) variacao], 120, posicaoInicialVertical);
		fonte.draw(batch, String.valueOf(pontuacao), larguraDispositivo / 2 - fonte.getScaleX()/2, alturaDispositivo - 50);
		if(comecou == false)
		{
			inicio.draw(batch, "Touch to Start!", larguraDispositivo / 2 - 200, alturaDispositivo/2);
		}
		if( estadoJogo == 2 ) {
			if(pontuacao > prefshighscore)
			{
				prefshighscore = pontuacao;
				prefs.putInteger("valor", pontuacao);
				prefs.flush();

			}
			if(intersticial == false) {
				adService.showInterstitial();
				intersticial = true;
			}
			score.draw(batch, "Score: "+ String.valueOf(pontuacao), larguraDispositivo / 2 - 200, alturaDispositivo / 2 + gameOver.getHeight()/25);
			highscore.draw(batch, "HighScore: " + String.valueOf(prefshighscore), larguraDispositivo / 2 - 200, alturaDispositivo / 2 - gameOver.getHeight()/2);
			mensagem.draw(batch, "Touch to Restart!", larguraDispositivo / 2 - 230, alturaDispositivo / 2 - gameOver.getHeight());
			batch.draw(gameOver, larguraDispositivo / 2 - gameOver.getWidth() / 2, alturaDispositivo / 2);
		}

		batch.end();

		passaroCirculo.set(120 + passaros[0].getWidth() / 2, posicaoInicialVertical + passaros[0].getHeight() / 2, passaros[0].getWidth() / 2);
		retanguloCanoBaixo = new Rectangle(
				posicaoMovimentoCanoHorizontal, alturaDispositivo / 2 - canoBaixo.getHeight() - espacoEntreCanos / 2 + alturaEntreCanosRandomica,
				canoBaixo.getWidth(), canoBaixo.getHeight()
		);

		retanguloCanoTopo = new Rectangle(
				posicaoMovimentoCanoHorizontal, alturaDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica,
				canoTopo.getWidth(), canoTopo.getHeight()
		);

		//Desenhar formas
        /*shape.begin( ShapeRenderer.ShapeType.Filled);
        shape.circle(passaroCirculo.x, passaroCirculo.y, passaroCirculo.radius);
        shape.rect(retanguloCanoBaixo.x, retanguloCanoBaixo.y, retanguloCanoBaixo.width, retanguloCanoBaixo.height);
        shape.rect(retanguloCanoTopo.x, retanguloCanoTopo.y, retanguloCanoTopo.width, retanguloCanoTopo.height);
        shape.setColor(Color.RED);
        shape.end();*/

		//Teste de colisão
		if( Intersector.overlaps( passaroCirculo, retanguloCanoBaixo ) || Intersector.overlaps(passaroCirculo, retanguloCanoTopo)
				|| posicaoInicialVertical <= 0 || posicaoInicialVertical >= alturaDispositivo ){
			//Gdx.app.log("Colisão", "Houve colisão");
			estadoJogo = 2;
			velocidade = 0;
		}

	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}
	public AdService adService;
	public FlappyBird(AdService ads){
		adService=ads;
	}
}
