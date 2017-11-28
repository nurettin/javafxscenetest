package in.nurett;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Takvim");
        Parent root = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void runSolver() {
        Model model = new Model("Takvim");
        IntVar ders1_gun = model.intVar("ders1_gun", 1, 5);
        IntVar ders2_gun = model.intVar("ders2_gun", 1, 5);
        IntVar ders3_gun = model.intVar("ders3_gun", 1, 5);
        IntVar ders4_gun = model.intVar("ders4_gun", 1, 5);
        IntVar ders1_saat = model.intVar("ders1_saat", 1, 10);
        IntVar ders2_saat = model.intVar("ders2_saat", 1, 10);
        IntVar ders3_saat = model.intVar("ders3_saat", 1, 10);
        IntVar ders4_saat = model.intVar("ders4_saat", 1, 10);

        IntVar ders1 = ders1_gun.mul(100).add(ders1_saat).intVar();
        IntVar ders2 = ders2_gun.mul(100).add(ders2_saat).intVar();
        IntVar ders3 = ders3_gun.mul(100).add(ders3_saat).intVar();
        IntVar ders4 = ders4_gun.mul(100).add(ders4_saat).intVar();

        model.allDifferent(ders1, ders2, ders3, ders4).post();
        model.allDifferent(ders1_gun, ders3_gun).post();

        ders1_gun.eq(ders2_gun).post();
        ders3_gun.eq(ders4_gun).post();
        ders1_saat.add(1).eq(ders2_saat).post();
        ders3_saat.add(1).eq(ders4_saat).post();
        ders3_gun.eq(5).post();
        ders1_gun.ne(ders3_gun).post();
        ders1_saat.gt(3).post();
        ders3_saat.gt(3).post();
        ders1_saat.lt(7).post();
        ders3_saat.lt(7).post();

        Solver solver = model.getSolver();
        int cozum = 1;
        while (solver.solve()) {
//            System.out.println("cozum: " + cozum);
//            System.out.println("-------------------");
//            System.out.println("ders1: " + ders1_gun + ", " + ders1_saat);
//            System.out.println("ders2: " + ders2_gun + ", " + ders2_saat);
//            System.out.println("ders3: " + ders3_gun + ", " + ders3_saat);
//            System.out.println("ders4: " + ders4_gun + ", " + ders4_saat);
//            System.out.println("-------------------");
            ++cozum;
        }
    }
}
