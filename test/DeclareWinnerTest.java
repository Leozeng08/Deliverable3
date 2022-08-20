/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import ca.sheridancollege.project.Player;
import ca.sheridancollege.project.PlayerOfWarGame;
import ca.sheridancollege.project.WarGame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author liangzeng
 */
public class DeclareWinnerTest {
    
    public DeclareWinnerTest() {
    }
    
    public void testDeclareWinnerGood(){
        System.out.println("Declare winner test: Good");
        PlayerOfWarGame player = new PlayerOfWarGame("Human");
        String expResult = "Human";
        String result= WarGame.declareWinner(player);
        assertEquals(expResult, result);
    }
    
    public void testDeclareWinnerbad(){
        System.out.println("Declare winner test: bad");
        PlayerOfWarGame player = new PlayerOfWarGame("human123");
        String expResult = "Human";
        String result= WarGame.declareWinner(player);
        assertEquals(expResult, result);
    
    }
    
    public void testDeclareWinnerBoundry(){
        System.out.println("Declare winner test: Boundry");
        PlayerOfWarGame player = new PlayerOfWarGame("human");
        String expResult = "Human";
        String result= WarGame.declareWinner(player);
        assertEquals(expResult, result);
    
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
