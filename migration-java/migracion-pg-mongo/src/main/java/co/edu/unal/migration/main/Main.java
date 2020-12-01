/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.main;

import co.edu.unal.migration.Migration;
import co.edu.unal.migration.util.FileUtil;
import java.io.File;

/**
 *
 * @author edwar
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("\n\n------------------------------------------");
        System.out.println("Universidad Nacional de Colombia");
        System.out.println("By. Edwar Rojas edrojasb@unal.edu.co");
        System.out.println("Migration");
        System.out.println("------------------------------------------\n");

        Migration mig = new Migration();

        System.out.println("Migrando Agentes ...");
        String agentesJson = mig.getAgentesJson();
        File f = new File("./output/agentes.json");
        FileUtil.createFolder(f.getParentFile());
        FileUtil.createFile(f);
        FileUtil.writeFile(agentesJson, f);

        System.out.println("\n\nMigrando Llamadas ...");
        String llamadasJson = mig.getLlamadasJson();
        f = new File("./output/llamadas.json");
        FileUtil.createFolder(f.getParentFile());
        FileUtil.createFile(f);
        FileUtil.writeFile(llamadasJson, f);

        System.out.println("\n\nEnd Process");

    }

}
