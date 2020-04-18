package View;

import DAO.Exporter;
import DAO.Importer;
import Entity.IncomeRecord;
import Entity.UserAccount;
import Service.DeleteService;
import Service.Function.Calculator;
import Service.Function.RecordListMaker;
import Service.Impl.DeleteServiceImpl;
import Service.Impl.InsertServiceImpl;
import Service.Impl.SignUpServiceImpl;
import Service.Impl.UpdateServiceImpl;
import Service.InsertService;
import Service.SignUpService;
import Service.UpdateService;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.AccessibleRole;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends Application {
    //
    private boolean isChange = false;
    //导入服务
    Importer importer = new Importer();
    Exporter exporter = new Exporter();
    UserAccount userAccount ;
    InsertService insertService;
    UpdateService updateService;
    DeleteService deleteService;
    SignUpService signUpService;
    Calculator calculator;
    RecordListMaker recordListMaker;


    //资源加载
    Image Icon = new Image("file:"+Thread.currentThread().getContextClassLoader().getResource("config/icon.jpg").getPath());
    Parent parent = FXMLLoader.load(getClass().getResource("Fxml/Main.fxml"));
    Parent saveParent =  FXMLLoader.load(getClass().getResource("Fxml/saveView.fxml"));
    @FXML
    Parent pane = (Parent) parent.lookup("#pane");
    TabPane tabPane = (TabPane)((Object)parent);
    Button exitButton = (Button) parent.lookup("#exitbutton");

    //个人界面
    Text balance = (Text)pane.lookup("#balance");
    Text weekIncome = (Text)pane.lookup("#weekIncome");
    Text monthIncome = (Text)pane.lookup("#monthIncome");

    TextField target = (TextField)pane.lookup("#target");
    Parent Stack = (Parent) pane.lookup("#Stack");
    Text rateText = (Text)Stack.lookup("#rateText");
    Arc RateArc = (Arc)pane.lookup("#RateArc");

    //表格界面
    Tab RecordTab = tabPane.getTabs().get(2);
    TableView table = (TableView)parent.lookup("#Table");
    TableColumn dateColumn = table.getVisibleLeafColumn(0);
    TableColumn moneyColumn = table.getVisibleLeafColumn(1);
    TableColumn noteColumn = table.getVisibleLeafColumn(2);
    TextField incomeField = (TextField)parent.lookup("#Income");
    TextField noteField = (TextField)parent.lookup("#note");
    Button insertButton = (Button)parent.lookup("#insert");
    Button updateButton = (Button)parent.lookup("#update");
    Button deleteButton = (Button)parent.lookup("#delete");
    Text successTip = (Text)parent.lookup("#successTip");
    Text failTip = (Text)parent.lookup("#failTip");
    Tab RecordView;
    //曲线图界面
    Parent Tips = (Parent) parent.lookup("#Tips");
    Text dateTip = (Text)Tips.lookup("#dateTip");
    Text moneyTip = (Text)Tips.lookup("#moneyTip");
    LineChart<String,Number> lineChart = (LineChart)parent.lookup("#lineChart");
    CategoryAxis xAxis = (CategoryAxis)parent.lookup("#xAxis");
    NumberAxis yAxis = (NumberAxis)parent.lookup("#yAxis");
    XYChart.Series series = new XYChart.Series();
    private ObservableList<IncomeRecord> dataList;

    //小窗口集合
    Stage saveStage = new Stage();
    Button save = (Button) saveParent.lookup("#save");
    Button dontSave = (Button) saveParent.lookup("#dontsave");
    Button cancelSave = (Button) saveParent.lookup("#cancel");


    Stage signUpStage = new Stage();
    Parent SignUpparent = FXMLLoader.load(getClass().getResource("Fxml/SignUpView.fxml"));
    TextField username = (TextField)SignUpparent.lookup("#username");
    TextField targetField = (TextField)SignUpparent.lookup("#target");
    Text warning = (Text)SignUpparent.lookup("#warning");
    Button signUp = (Button)SignUpparent.lookup("#signUp");

    public MainFrame() throws IOException {
    }
    //初始化服务，添加注册程序
    public boolean InitServices(){
        userAccount = importer.start();
        //不存在用户
        if(userAccount==null){
            return false;
        }
        calculator = new Calculator(userAccount);
        insertService = new InsertServiceImpl(userAccount);
        deleteService = new DeleteServiceImpl(userAccount);
        updateService = new UpdateServiceImpl(userAccount);
        recordListMaker = new RecordListMaker(userAccount);
        return true;
    }
    //初始化控件属性
    public void InitAttribute(){
        //当前无账号
        if(userAccount==null){
            System.out.println("初始化控件属性失败");
            return;
        }
        refreshData();

        //图表
        dataList = FXCollections.observableArrayList(userAccount.getRecordList());
        table.setEditable(true);
        dateColumn.setCellValueFactory(
                new PropertyValueFactory<>("date"));
        moneyColumn.setCellValueFactory(
                new PropertyValueFactory<>("Income"));
        noteColumn.setCellValueFactory(
                new PropertyValueFactory<>("note"));

        table.setItems(dataList);
        //曲线图
//        xAxis.setLowerBound(1);
//        xAxis.setUpperBound(31);
//        xAxis.setTickUnit(1);
//       xAxis.setMinorTickCount(0);

        lineChart.getData().add(series);
        //窗口
        saveStage.setScene(new Scene(saveParent));
        saveStage.setAlwaysOnTop(true);
        saveStage.centerOnScreen();
        saveStage.setTitle("兔粮");
    }
    //刷新控件数据
    public void refreshData(){
        if(userAccount==null){
            System.out.println("NULL");
            return;
        }
        //个人界面
        balance.setText(Double.toString(userAccount.getBalance()));
        target.setText(Double.toString(userAccount.getTarget()));
        weekIncome.setText(Double.toString(calculator.add(7)));
        monthIncome.setText(Double.toString(calculator.add(30)));
        rateText.setText(Integer.toString((int)(calculator.getCompleteness()*100))+"%");
        RateArc.setLength(360 * calculator.getCompleteness());
        //曲线图界面
        makeLine(30);
    }
    //加入监听模块
    public void addActon(Stage stage){
        //个人界面监听

        target.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(checkInput(target.getText())){
                    double targetNum = Double.parseDouble(target.getText());
                    if(targetNum!=userAccount.getTarget()){
                        isChange = true;
                        userAccount.setTarget(targetNum);
                        //刷新数据
                        rateText.setText(Integer.toString((int)(calculator.getCompleteness()*100))+"%");
                        RateArc.setLength(360 * calculator.getCompleteness());
                    }
                }


            }
        });
        target.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.requestFocus();
            }
        });

        //表格tab监听
        //刷新提示语
        RecordTab.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if(!RecordTab.isSelected()){
                    successTip.setVisible(false);
                    failTip.setVisible(false);
                }

            }
        });
        //插入按钮
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(checkInput(incomeField.getText())){
                    isChange = true;
                    double Income = Double.parseDouble(incomeField.getText());
                    String note = noteField.getText();
                    IncomeRecord incomeRecord = insertService.insertData(Income, note);
                    ObservableList<XYChart.Data> chartList = series.getData();
                    XYChart.Data chartData = new XYChart.Data(incomeRecord.getDate(),incomeRecord.getIncome());
                    if(userAccount.getRecordList().size()==dataList.size()){//插入相同日期
                        dataList.set(dataList.size()-1, incomeRecord);
                        chartList.set(chartList.size()-1, chartData);
                    }
                    else {//不同日期
                        dataList.add(incomeRecord);
                        chartList.add(chartData);
                    }
                    //刷新画面
                    refreshData();
                    successTip.setVisible(true);
                    failTip.setVisible(false);
                }
                else {
                    successTip.setVisible(false);
                    failTip.setVisible(true);
                }
                incomeField.clear();
                noteField.clear();
            }
        });
        //更新按钮
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index = 0;
                //未选中
                if(table.getSelectionModel().isEmpty()){

                }else {
                    if(checkInput(incomeField.getText())){
                        isChange = true;
                        index = table.getSelectionModel().getFocusedIndex();
                        double Income = Double.parseDouble(incomeField.getText());
                        String note = noteField.getText();
                        //更新数据
                        IncomeRecord incomeRecord = updateService.UpdateData(index,Income,note);
                        ObservableList<XYChart.Data> chartList = series.getData();
                        XYChart.Data chartData = new XYChart.Data(incomeRecord.getDate(),incomeRecord.getIncome());
                        dataList.set(index, incomeRecord);
                        chartList.set(index, chartData);
                        //刷新画面
                        refreshData();
                        successTip.setVisible(true);
                        failTip.setVisible(false);
                    }
                    else {
                        successTip.setVisible(false);
                        failTip.setVisible(true);
                    }
                }
                incomeField.clear();
                noteField.clear();
            }
        });
        //删除按钮
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index = 0;
                //未选中
                if(table.getSelectionModel().isEmpty()){

                }else {
                    isChange = true;
                    index = table.getSelectionModel().getFocusedIndex();
                    ObservableList<XYChart.Data> chartList = series.getData();
                    dataList.remove(index);
                    chartList.remove(index);
                    deleteService.DeleteData(index);
                    //刷新画面
                    refreshData();
                    successTip.setVisible(true);
                    failTip.setVisible(false);
                }
                incomeField.clear();
                noteField.clear();
            }

        });
        //退出程序
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //导出数据
                if(isChange) {
                    saveStage.show();
                }
                else {
                    stage.close();
                }
            }
        });
        //保存文件监听
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                exporter.start(userAccount);
                stage.close();
                saveStage.close();
            }
        });
        dontSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
                saveStage.close();
            }
        });
        cancelSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveStage.close();
            }
        });
    }
    //构造chartList
    public void makeLine(int lastDay){
        ObservableList<XYChart.Data> list = FXCollections.observableArrayList();
        ArrayList<IncomeRecord> incomeRecords = recordListMaker.getRecordList(lastDay);
        series.setName("最近"+Integer.toString(lastDay)+"天");
        for(IncomeRecord incomeRecord:incomeRecords){
            XYChart.Data data = new XYChart.Data(incomeRecord.getDate(),incomeRecord.getIncome());
            list.add(data);
            //加入控件显示
            Text text = new Text(Double.toString(incomeRecord.getIncome()));
            Node symbol = new StackPane();
            symbol.setAccessibleRole(AccessibleRole.TEXT);
            //曲线图结点监听
            symbol.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    double x = symbol.getLayoutX() + 80;
                    double y = symbol.getLayoutY();
                    double tips_width = Tips.getBoundsInParent().getWidth();
                    if(x+tips_width>525){
                        x = 525-Tips.getBoundsInParent().getWidth();
                    }
                    Tips.setLayoutX(x);
                    Tips.setLayoutY(y);
                    //刷新tip组件
                    Tips.setVisible(true);
                    dateTip.setText(data.getXValue().toString());
                    moneyTip.setText(data.getYValue().toString());
                }
            });
            symbol.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Tips.setVisible(false);
                }
            });
            data.setNode(symbol);
        }
        series.setData(list);
    }
    //检测输入合法性
    public boolean checkInput(String input){

        if(input.matches("\\d+(\\.\\d)?")){

            return true;
        }
        return false;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //定义控件

        if(!InitServices()){
            //primaryStage.close();
            //初始化窗口
            signUp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(checkInput(targetField.getText())){
                        userAccount = signUpService.SignUp(username.getText(), Double.parseDouble(targetField.getText()));
                        exporter.start(userAccount);
                        System.out.println("初始化成功");

                        signUpStage.close();
                        try {
                            new MainFrame().start(new Stage());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    else {
                        warning.setVisible(true);
                        targetField.clear();
                    }
                }
            });
            System.out.println("用户不存在");
            signUpService = new SignUpServiceImpl();
            signUpStage.setScene(new Scene(SignUpparent));
            signUpStage.setResizable(false);
            signUpStage.setTitle("初始化");
            signUpStage.centerOnScreen();
            signUpStage.setAlwaysOnTop(true);
            signUpStage.getIcons().add(Icon);
            signUpStage.show();
            return;
        }
        InitAttribute();
        addActon(primaryStage);
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("兔粮");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(Icon);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}




