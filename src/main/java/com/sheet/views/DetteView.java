package com.sheet.views;

import java.util.List;
import java.util.Scanner;

import com.sheet.data.entities.Dette;
import com.sheet.services.DetteServ;

public class DetteView {
    private Scanner scanner;
    private DetteServ detteServ;

    public DetteView(Scanner scanner, DetteServ detteServ) {
        this.scanner = scanner;
        this.detteServ = detteServ;
    }

    public void showAllDettes() {
        detteServ.findDettes().forEach(dette -> System.out.println(dette.toString()));
    }

    public Dette ArchivedValidateDette() {
        List<Dette> dettes = detteServ.findDettes();
        System.out.println("Choisir la dette à valider : ");
        for (int i = 0; i < dettes.size(); i++) {
            System.out.println(i + " - " + dettes.get(i).toString());
        }

        int choix = scanner.nextInt();
        scanner.nextLine();
        if (choix < 0 || choix >= dettes.size()) {
            System.out.println("Choix invalide");
            return null;
        }

        Dette dette = dettes.get(choix);
        return dette;
    }

}
