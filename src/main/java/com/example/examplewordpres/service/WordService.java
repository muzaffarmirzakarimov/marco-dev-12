package com.example.examplewordpres.service;

import com.example.examplewordpres.dto.ApiResponse;
import com.example.examplewordpres.entity.*;
import com.example.examplewordpres.repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class WordService {

    private final MainPageRepository mainPageRepository;
    private final DetailDescriptionRepository detailDescriptionRepository;
    private final LaboratoryRepository laboratoryRepository;
    private final ChemicalRepository chemicalRepository;
    private final WorkerHomeworkRepository workerHomeworkRepository;
    private final JavaMailSender javaMailSender;
    private final UserRepository userRepository;




    public ApiResponse WordWrite(List<Long> id) throws IOException {

        id.forEach(integer -> {
            Optional<MainPage> byId = mainPageRepository.findById(integer);
            if (byId.isPresent()) {



                MainPage mainPage = byId.get();
                WorkerHomework workerHomework = mainPage.getWorkerHomework();
                Laboratory laboratory = mainPage.getLaboratory();
                DetailDescription detailDescription = mainPage.getDetailDescription();
                    Optional<Chemical> byName = chemicalRepository.findByName(workerHomework.getChemicalName());
                    Chemical chemical = byName.get();



                    XWPFDocument document = new XWPFDocument();
                FileOutputStream outputStream = null;

                try {
                    outputStream = new FileOutputStream(new File("src/main/java/com/example/examplewordpres/word/"+workerHomework.getFuse()+".docx"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                //create table
                    XWPFTable table = document.createTable(45,13);
                    table.setWidth(-5);
                    table.setTableAlignment(TableRowAlign.CENTER);
                    table.setColBandSize(5);
//   1 - qator
                    mergeCellHorizontally(table,0,0,1);

                    mergeCellHorizontally(table,0,1,3);

                    mergeCellHorizontally(table,0,2,4);

                    mergeCellHorizontally(table,0,3,7);

                    table.getRow(0).getCell(0).setText("Печь № "+ workerHomework.getBake());
                    table.getRow(0).getCell(1).setText("Плавка № "+workerHomework.getFuse());
                    table.getRow(0).getCell(2).setText("Дата: "+workerHomework.getLocalDateTime());
                    table.getRow(0).getCell(3).setText("Плавильщик: "+workerHomework.getSmelter());






//    2-qator


                    mergeCellVertically(table, 0, 1, 3);
                    mergeCellHorizontally(table, 1, 0, 1);
                    mergeCellHorizontally(table, 2, 0, 1);
                    mergeCellHorizontally(table, 3, 0, 1);


                    mergeCellHorizontally(table, 1, 1, 3);
                    mergeCellHorizontally(table, 2, 1, 3);
                    mergeCellHorizontally(table, 3, 1, 3);
                    mergeCellVertically(table,1,2,3);

                    mergeCellHorizontally(table, 1, 7, 8);
                    mergeCellHorizontally(table, 2, 7, 8);
                    mergeCellHorizontally(table, 3, 7, 8);

                    table.getRow(1).getCell(0).setText("Марка металл\n"+workerHomework.getChemicalName());
                    table.getRow(1).getCell(1).setText("Хим.состав");
                    table.getRow(2).getCell(1).setText("Заданный\n Полученный");
                    table.getRow(1).getCell(2).setText("С");
                    table.getRow(1).getCell(3).setText("Mn");
                    table.getRow(1).getCell(4).setText("Si");
                    table.getRow(1).getCell(5).setText("S");
                    table.getRow(1).getCell(6).setText("P");
                    table.getRow(1).getCell(7).setText("HB");
                    table.getRow(1).getCell(8).setText("?");

                    table.getRow(2).getCell(2).setText(chemical.getModa1());
                    table.getRow(2).getCell(3).setText(chemical.getModa2());
                    table.getRow(2).getCell(4).setText(chemical.getModa3());
                    table.getRow(2).getCell(5).setText(chemical.getModa4());
                    table.getRow(2).getCell(6).setText(chemical.getModa5());
                    table.getRow(2).getCell(7).setText(chemical.getModa1());
                    table.getRow(2).getCell(8).setText(chemical.getModa1());

                    table.getRow(3).getCell(2).setText(String.valueOf(workerHomework.getModa1()));
                    table.getRow(3).getCell(3).setText(String.valueOf(workerHomework.getModa1()));
                    table.getRow(3).getCell(4).setText(String.valueOf(workerHomework.getModa1()));
                    table.getRow(3).getCell(5).setText(String.valueOf(workerHomework.getModa1()));
                    table.getRow(3).getCell(6).setText(String.valueOf(workerHomework.getModa1()));
                    table.getRow(3).getCell(7).setText(String.valueOf(workerHomework.getModa1()));
                    table.getRow(3).getCell(8).setText(String.valueOf(workerHomework.getModa1()));



//// 4-qator

                   mergeCellHorizontally(table,4,0,1);
                   mergeCellHorizontally(table,4,1,2);
                   mergeCellHorizontally(table,4,2,3);
                   mergeCellHorizontally(table,4,3,4);
                   mergeCellHorizontally(table,4,4,5);
                   mergeCellHorizontally(table,4,5,7);

                   table.getRow(4).getCell(0).setText("Завалка");
                   table.getRow(4).getCell(1).setText("Масса кг");
                   table.getRow(4).getCell(2).setText("Период плавки");
                   table.getRow(4).getCell(3).setText("Начало");
                   table.getRow(4).getCell(4).setText("Конец");
                   table.getRow(4).getCell(5).setText("Продолжит");




//// 5-qator
//

                    mergeCellHorizontally(table,5,0,1);
                    mergeCellHorizontally(table,5,1,2);
                    mergeCellHorizontally(table,5,2,3);
                    mergeCellHorizontally(table, 5, 7, 8);




//// 6-qator
                    mergeCellHorizontally(table,6,0,1);
                    mergeCellHorizontally(table,6,1,2);
                    mergeCellHorizontally(table,6,2,3);
                    mergeCellHorizontally(table, 6, 7, 8);

//// 7-qator
                    mergeCellHorizontally(table,7,0,1);
                    mergeCellHorizontally(table,7,1,2);
                    mergeCellHorizontally(table,7,2,3);
                    mergeCellHorizontally(table, 7, 7, 8);

//// 8-qator
                    mergeCellHorizontally(table,8,0,1);
                    mergeCellHorizontally(table,8,1,2);
                    mergeCellHorizontally(table,8,2,3);
                    mergeCellHorizontally(table, 8, 7, 8);
////9-qator
                    mergeCellHorizontally(table,9,0,1);
                    mergeCellHorizontally(table,9,1,2);
                    mergeCellHorizontally(table,9,2,3);
                    mergeCellHorizontally(table, 9, 7, 8);
////10-qator
                    mergeCellHorizontally(table,10,0,1);
                    mergeCellHorizontally(table,10,1,2);
                    mergeCellHorizontally(table,10,2,3);
                    mergeCellHorizontally(table, 10, 7, 8);


//11-qator
                    mergeCellHorizontally(table,11,0,1);
                    mergeCellHorizontally(table,11,1,2);
                    mergeCellHorizontally(table,11,2,3);
                    mergeCellHorizontally(table, 11, 7, 8);


                    for (int i = 0; i < workerHomework.getTestList().size(); i++) {

                        table.getRow(5+i).getCell(0).setText(workerHomework.getTestList().get(i).getNomalum().getFill());
                        table.getRow(5+i).getCell(1).setText(String.valueOf(workerHomework.getTestList().get(i).getNomalum().getMacca()));
                        table.getRow(5+i).getCell(2).setText(workerHomework.getTestList().get(i).getNomalum().getConstant().getName());
                        table.getRow(5+i).getCell(3).setText(String.valueOf(workerHomework.getTestList().get(i).getNomalum().getStart()));
                        table.getRow(5+i).getCell(5).setText(String.valueOf(workerHomework.getTestList().get(i).getNomalum().getFinish()));
                        table.getRow(5+i).getCell(7).setText(String.valueOf(workerHomework.getTestList().get(i).getNomalum().getContinus()));
                    }




////12-qator


                    mergeCellVertically(table,8,20,23);
                    mergeCellVertically(table,9,20,23);
                    mergeCellVertically(table,10,20,23);
                    mergeCellVertically(table,11,20,23);

                    mergeCellHorizontally(table,12,2,3);
                    mergeCellHorizontally(table,12,3,4);

                    table.getRow(12).getCell(0).setText("Всего");
                    table.getRow(12).getCell(1).setText(String.valueOf(laboratory.getTotal()));
                    table.getRow(12).getCell(2).setText("По скач.шл");
                    table.getRow(12).getCell(3).setText("Анализ по ходу");
                    table.getRow(12).getCell(4).setText("Время");
                    table.getRow(12).getCell(5).setText("С");
                    table.getRow(12).getCell(6).setText("Mn");
                    table.getRow(12).getCell(7).setText(" Si  ");
                    table.getRow(12).getCell(8).setText(" S  ");
                    table.getRow(12).getCell(9).setText(" P  ");
                    table.getRow(12).getCell(10).setText(" Al ");








//13 -qator

                    mergeCellHorizontally(table,13,2,3);
                    mergeCellHorizontally(table,13,3,4);
                    table.getRow(13).getCell(0).setText("шлак");
                    table.getRow(13).getCell(1).setText(String.valueOf(laboratory.getSlag()));
                    table.getRow(13).getCell(2).setText(String.valueOf(laboratory.getByskachShlag()));



//14 -qator

                    mergeCellHorizontally(table,14,0,1);
                    mergeCellHorizontally(table,14,1,2);
                    mergeCellHorizontally(table,14,2,3);
                    table.getRow(14).getCell(0).setText("Присадки");
                    table.getRow(14).getCell(1).setText("Масс кг");




//15-qator

                    mergeCellHorizontally(table,15,0,1);
                    mergeCellHorizontally(table,15,1,2);
                    mergeCellHorizontally(table,15,2,3);
                    table.getRow(15).getCell(0).setText("FeMn  "+laboratory.getAdditivesFeMn());
                    table.getRow(15).getCell(1).setText(String.valueOf(laboratory.getMassaFeMn()));


//16 -qator

                    mergeCellHorizontally(table,16,0,1);
                    mergeCellHorizontally(table,16,1,2);
                    mergeCellHorizontally(table,16,2,3);
                    table.getRow(16).getCell(0).setText("Fesi  "+laboratory.getAdditivesFeSi());
                    table.getRow(16).getCell(1).setText(String.valueOf(laboratory.getMassaFeSi()));










//17 -qator

                    mergeCellHorizontally(table,17,4,5);
                    table.getRow(17).getCell(0).setText("FeV ");
                    table.getRow(17).getCell(1).setText("FeP ");
                    table.getRow(17).getCell(2).setText(String.valueOf(laboratory.getFev()));
                    table.getRow(17).getCell(3).setText(String.valueOf(laboratory.getFeP()));






//18-qator
                    mergeCellHorizontally(table,18,4,5);
                    table.getRow(18).getCell(0).setText("Al ");
                    table.getRow(18).getCell(1).setText("SiCa ");
                    table.getRow(18).getCell(2).setText(String.valueOf(laboratory.getAl()));
                    table.getRow(18).getCell(3).setText(String.valueOf(laboratory.getSiCa()));


//19-qator
                    mergeCellHorizontally(table,19,4,5);
                    table.getRow(19).getCell(0).setText("    ");





//20-qator

                    mergeCellHorizontally(table,20,0,3);
                    mergeCellHorizontally(table,20,1,2);
                    mergeCellHorizontally(table,20,2,3);
                    mergeCellHorizontally(table,20,3,7);
                    table.getRow(20).getCell(0).setText("Cтойкость футеровки\n" +
                            "количество плавок");
                    table.getRow(20).getCell(1).setText("Подина стена");
                    table.getRow(20).getCell(2).setText("Свод");
                    table.getRow(20).getCell(3).setText("Замечания по ходу плавки\n"
                            +laboratory.getRemarks());


//21-qator


                    mergeCellHorizontally(table,21,0,3);
                    mergeCellHorizontally(table,21,1,4);
                    mergeCellHorizontally(table,21,2,6);
                    table.getRow(21).getCell(0).setText("Температура металл");
                    table.getRow(21).getCell(1).setText("Время выпуска металл");




//22-qator

                    mergeCellHorizontally(table,22,0,1);
                    mergeCellHorizontally(table,22,1,2);
                    mergeCellHorizontally(table,22,2,3);
                    mergeCellHorizontally(table,22,3,4);
                    mergeCellHorizontally(table,22,4,8);
                    table.getRow(22).getCell(0).setText("Начало\n" +
                            "выпуска с печи");
                    table.getRow(22).getCell(1).setText(String.valueOf(laboratory.getTempBegin()));
                    table.getRow(22).getCell(2).setText("Начало");
                    table.getRow(22).getCell(3).setText(String.valueOf(laboratory.getTimeBegin()));



//23-qator

                    mergeCellHorizontally(table,23,0,1);
                    mergeCellHorizontally(table,23,1,2);
                    mergeCellHorizontally(table,23,2,3);
                    mergeCellHorizontally(table,23,3,4);
                    mergeCellHorizontally(table,23,4,8);
                    table.getRow(23).getCell(0).setText("Конес\n" +
                            "выпуска с печи");
                    table.getRow(23).getCell(1).setText(String.valueOf(laboratory.getTempEnd()));
                    table.getRow(23).getCell(2).setText("Конес");
                    table.getRow(23).getCell(3).setText(String.valueOf(laboratory.getTimeEnd()));

                    for (int i = 0; i < laboratory.getProbas().size(); i++) {

                        table.getRow(13+i).getCell(4).setText(String.valueOf(laboratory.getProbas().get(i).getProba().getLocalTime()));
                        table.getRow(13+i).getCell(5).setText(String.valueOf(laboratory.getProbas().get(i).getProba().getModa1()));
                        table.getRow(13+i).getCell(6).setText(String.valueOf(laboratory.getProbas().get(i).getProba().getModa2()));
                        table.getRow(13+i).getCell(7).setText(String.valueOf(laboratory.getProbas().get(i).getProba().getModa3()));
                        table.getRow(13+i).getCell(8).setText(String.valueOf(laboratory.getProbas().get(i).getProba().getModa4()));
                        table.getRow(13+i).getCell(9).setText(String.valueOf(laboratory.getProbas().get(i).getProba().getModa5()));
                        table.getRow(13+i).getCell(10).setText(String.valueOf(laboratory.getProbas().get(i).getProba().getModa6()));
                    }


                    for (int i = 0; i < laboratory.getLadles().size(); i++) {
                        table.getRow(16+i).getCell(3).setText(String.valueOf(laboratory.getLadles().get(i).getLadle().getLocalTime()));
                        table.getRow(16+i).getCell(4).setText(String.valueOf(laboratory.getLadles().get(i).getLadle().getModa1()));
                        table.getRow(16+i).getCell(5).setText(String.valueOf(laboratory.getLadles().get(i).getLadle().getModa2()));
                        table.getRow(16+i).getCell(6).setText(String.valueOf(laboratory.getLadles().get(i).getLadle().getModa3()));
                        table.getRow(16+i).getCell(7).setText(String.valueOf(laboratory.getLadles().get(i).getLadle().getModa4()));
                        table.getRow(16+i).getCell(8).setText(String.valueOf(laboratory.getLadles().get(i).getLadle().getModa5()));
                        table.getRow(16+i).getCell(9).setText(String.valueOf(laboratory.getLadles().get(i).getLadle().getModa6()));
                    }






//24 -qator

                    mergeCellHorizontally(table,24,0,12);
                    table.getRow(24).getCell(0).setText("Залито деталей");



//25-qator
                    mergeCellVertically(table,0,25,26);


                    mergeCellHorizontally(table,25,0,3);
                    mergeCellHorizontally(table,25,1,9);
                    table.getRow(25).getCell(0).setText("Заливщик");
                    table.getRow(25).getCell(1).setText(detailDescription.getCaster1());



//26-qator
                    mergeCellHorizontally(table,26,0,3);
                    mergeCellHorizontally(table,26,1,9);
                    table.getRow(26).getCell(1).setText(detailDescription.getCaster2());




//27-qator


                    mergeCellHorizontally(table,27,1,3);
                    mergeCellHorizontally(table,27,2,3);
                    mergeCellHorizontally(table,27,4,5);

                    mergeCellHorizontally(table,27,5,6);
                    mergeCellHorizontally(table,27,6,7);
                    table.getRow(27).getCell(0).setText(" № ");
                    table.getRow(27).getCell(1).setText(" Наименование отливки ");
                    table.getRow(27).getCell(2).setText(" Кол-во\n " +
                            "форм");
                    table.getRow(27).getCell(3).setText(" Кол-во\n " +
                            "отливок");
                    table.getRow(27).getCell(4).setText(" Масса кг ");
                    table.getRow(27).getCell(5).setText(" Тем-ра\n" +
                            "Заливи ");
                    table.getRow(27).getCell(6).setText(" Примечение ");



//28-qator
                    mergeCellHorizontally(table,28,1,3);
                    mergeCellHorizontally(table,28,2,3);
                    mergeCellHorizontally(table,28,6,7);
                    mergeCellHorizontally(table,28,7,8);
                    mergeCellVertically(table,0,27,28);
                    mergeCellVertically(table,1,27,28);
                    mergeCellVertically(table,2,27,28);
                    mergeCellVertically(table,3,27,28);
                    mergeCellVertically(table,5,27,28);
                    mergeCellVertically(table,6,27,28);
                    table.getRow(28).getCell(4).setText("1 шт     ");
                    table.getRow(28).getCell(5).setText("общий");

//29-qator


                    mergeCellHorizontally(table,29,1,3);
                    mergeCellHorizontally(table,29,2,3);
                    mergeCellHorizontally(table,29,6,7);
                    mergeCellHorizontally(table,29,7,8);


//30-qator


                    mergeCellHorizontally(table,30,1,3);
                    mergeCellHorizontally(table,30,2,3);
                    mergeCellHorizontally(table,30,6,7);
                    mergeCellHorizontally(table,30,7,8);


//31-qator


                    mergeCellHorizontally(table,31,1,3);
                    mergeCellHorizontally(table,31,2,3);
                    mergeCellHorizontally(table,31,6,7);
                    mergeCellHorizontally(table,31,7,8);

//32-qator


                    mergeCellHorizontally(table,32,1,3);
                    mergeCellHorizontally(table,32,2,3);
                    mergeCellHorizontally(table,32,6,7);
                    mergeCellHorizontally(table,32,7,8);

//33-qator


                    mergeCellHorizontally(table,33,1,3);
                    mergeCellHorizontally(table,33,2,3);
                    mergeCellHorizontally(table,33,6,7);
                    mergeCellHorizontally(table,33,7,8);

//34-qator


                    mergeCellHorizontally(table,34,1,3);
                    mergeCellHorizontally(table,34,2,3);
                    mergeCellHorizontally(table,34,6,7);
                    mergeCellHorizontally(table,34,7,8);

//35-qator


                    mergeCellHorizontally(table,35,1,3);
                    mergeCellHorizontally(table,35,2,3);
                    mergeCellHorizontally(table,35,6,7);
                    mergeCellHorizontally(table,35,7,8);

//36-qator


                    mergeCellHorizontally(table,36,1,3);
                    mergeCellHorizontally(table,36,2,3);
                    mergeCellHorizontally(table,36,6,7);
                    mergeCellHorizontally(table,36,7,8);
//37-qator


                    mergeCellHorizontally(table,37,1,3);
                    mergeCellHorizontally(table,37,2,3);
                    mergeCellHorizontally(table,37,6,7);
                    mergeCellHorizontally(table,37,7,8);

//38-qator


                    mergeCellHorizontally(table,38,1,3);
                    mergeCellHorizontally(table,38,2,3);
                    mergeCellHorizontally(table,38,6,7);
                    mergeCellHorizontally(table,38,7,8);
//39-qator


                    mergeCellHorizontally(table,39,1,3);
                    mergeCellHorizontally(table,39,2,3);
                    mergeCellHorizontally(table,39,6,7);
                    mergeCellHorizontally(table,39,7,8);

//40-qator


                    mergeCellHorizontally(table,40,1,3);
                    mergeCellHorizontally(table,40,2,3);
                    mergeCellHorizontally(table,40,6,7);
                    mergeCellHorizontally(table,40,7,8);


//41-qator


                    mergeCellHorizontally(table,41,1,3);
                    mergeCellHorizontally(table,41,2,3);
                    mergeCellHorizontally(table,41,6,7);
                    mergeCellHorizontally(table,41,7,8);

//42-qator


                    mergeCellHorizontally(table,42,1,3);
                    mergeCellHorizontally(table,42,2,3);
                    mergeCellHorizontally(table,42,6,7);
                    mergeCellHorizontally(table,42,7,8);


//43-qator


                    mergeCellHorizontally(table,43,1,3);
                    mergeCellHorizontally(table,43,2,3);
                    mergeCellHorizontally(table,43,6,7);
                    mergeCellHorizontally(table,43,7,8);


                    for (int i = 0; i < detailDescription.getList().size(); i++) {
                        table.getRow(29+i).getCell(0).setText(String.valueOf(detailDescription.getList().get(i).getId()));
                        table.getRow(29+i).getCell(1).setText(String.valueOf(detailDescription.getList().get(i).getNameCastings()));
                        table.getRow(29+i).getCell(2).setText(String.valueOf(detailDescription.getList().get(i).getKolform()));
                        table.getRow(29+i).getCell(3).setText(String.valueOf(detailDescription.getList().get(i).getBalls()));
                        table.getRow(29+i).getCell(4).setText(String.valueOf(detailDescription.getList().get(i).getWeightPcs()));
                        table.getRow(29+i).getCell(5).setText(String.valueOf(detailDescription.getList().get(i).getGeneralMassa()));
                        table.getRow(29+i).getCell(6).setText(String.valueOf(detailDescription.getList().get(i).getTemperaFills()));
                        table.getRow(29+i).getCell(7).setText(String.valueOf(detailDescription.getList().get(i).getNote()));
                    }


//44-qator
                    mergeCellHorizontally(table,44,0,3);
                    mergeCellHorizontally(table,44,1,3);
                    mergeCellHorizontally(table,44,2,4);
                    mergeCellHorizontally(table,44,3,5);

                    table.getRow(44).getCell(0).setText("Плавилшик\n  "+mainPage.getSmelter());
                    table.getRow(44).getCell(1).setText("Мастер плавку\n  "+mainPage.getSmeltingMaster());
                    table.getRow(44).getCell(2).setText("Контроллер ОТК\n "+mainPage.getControllerOTK());
                    table.getRow(44).getCell(3).setText("Началник участка\n  "+mainPage.getSectionManager());


                try {
                    outputStream.flush();
                    document.write(outputStream);
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                sendMessageAttechment("src/main/java/com/example/examplewordpres/word/"+workerHomework.getFuse()+".docx",workerHomework);
            }
        });

        return new ApiResponse("Success",true);
    }


    @Async
    public void sendMessageAttechment(String pathverible,WorkerHomework workerHomework){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users users = (Users) authentication.getPrincipal();
        String email = users.getEmail();
        String password = users.getEmailpassword();


        this.javaMailSender.send(new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
                mimeMessageHelper.setFrom(email);
                mimeMessageHelper.setTo("axmadaliyevfarruxbek967@gmail.com");
                mimeMessageHelper.setSubject(String.valueOf(workerHomework.getFuse()));
                mimeMessageHelper.setText(String.valueOf(workerHomework.getBake()));
                FileSystemResource file = new FileSystemResource(new File(pathverible));
                mimeMessageHelper.addAttachment(file.getFilename(), file);


//                mimeMessageHelper.addAttachment(file.getOriginalFilename(),file);
            }
        });
    }

    static void mergeCellVertically(XWPFTable table, int col, int fromRow, int toRow) {
        for(int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
            CTVMerge vmerge = CTVMerge.Factory.newInstance();
            if(rowIndex == fromRow){
                // The first merged cell is set with RESTART merge value
                vmerge.setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                vmerge.setVal(STMerge.CONTINUE);
                // and the content should be removed
                for (int i = cell.getParagraphs().size(); i > 0; i--) {
                    cell.removeParagraph(0);
                }
                cell.addParagraph();
            }
            // Try getting the TcPr. Not simply setting an new one every time.
            CTTcPr tcPr = cell.getCTTc().getTcPr();
            if (tcPr == null) tcPr = cell.getCTTc().addNewTcPr();
            tcPr.setVMerge(vmerge);
        }
    }

    //merging horizontally by setting grid span instead of using CTHMerge
    static void mergeCellHorizontally(XWPFTable table, int row, int fromCol, int toCol) {
        XWPFTableCell cell = table.getRow(row).getCell(fromCol);
        // Try getting the TcPr. Not simply setting an new one every time.
        CTTcPr tcPr = cell.getCTTc().getTcPr();
        if (tcPr == null) tcPr = cell.getCTTc().addNewTcPr();
        // The first merged cell has grid span property set
        if (tcPr.isSetGridSpan()) {
            tcPr.getGridSpan().setVal(BigInteger.valueOf(toCol-fromCol+1));
        } else {
            tcPr.addNewGridSpan().setVal(BigInteger.valueOf(toCol-fromCol+1));
        }
        // Cells which join (merge) the first one, must be removed
        for(int colIndex = toCol; colIndex > fromCol; colIndex--) {
            table.getRow(row).getCtRow().removeTc(colIndex);
            table.getRow(row).removeCell(colIndex);
        }
    }
}
