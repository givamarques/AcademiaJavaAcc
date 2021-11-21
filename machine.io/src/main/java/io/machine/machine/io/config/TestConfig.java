package io.machine.machine.io.config;

import io.machine.machine.io.models.*;
import io.machine.machine.io.models.enums.Status;
import io.machine.machine.io.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private MaquinaRepository maquinaRepository;

    @Autowired
    private OperadorRepository operadorRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public void run(String... args) throws Exception {

        Status status1;

        Modelo md1 = new Modelo("DELL 3010");
        Modelo md2 = new Modelo("DELL 3020");

        Maquina m1 = new Maquina(md1,"DTA123456JBTNET","123456789",true);
        Maquina m2 = new Maquina(md2,"DTA987654JBTNET","321987654",true);
        Maquina m3 = new Maquina(md1,"DTA321654JBTNET","654987321",true);
        Maquina m4 = new Maquina(md2,"DTA321987JBTNET","987654321",true);

        Supervisor s1 = new Supervisor("123455",
                "Rayane de Lima",
                "NET",
                "81999275749",
                "977832");
//
        Operador o1 = new Operador("123455",
                "Jorge de Lima e Silva",
                "NET",
                "81999275749",
                s1,
                "12345678985");
//
        Chamado c1 = new Chamado(s1,m1,Status.RECEBIDO, Instant.now());
//
//
        maquinaRepository.saveAll(Arrays.asList(m1,m2,m3,m4));
        modeloRepository.saveAll(Arrays.asList(md1,md2));
        supervisorRepository.save(s1);
        operadorRepository.save(o1);
        chamadoRepository.save(c1);

    }
}
