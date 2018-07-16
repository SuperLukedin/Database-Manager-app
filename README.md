<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="An interactive getting started guide for Brackets.">
        <link rel="stylesheet" href="Manual/main.css">
</head>
<h1>GETTING STARTED WITH MYSQL DATABASE MANAGER</h1>
        <h2>This is your guide!</h2>
        <h4>Prerequisites</h4>   
            <a href="https://dev.mysql.com/downloads/mysql/"><p>Mysql</p></a>
            <a href="https://www.tableau.com/products/desktop/download"><p>Tableau Desktop</p></a>
            <a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html"><p>Java SE Development Kit</p></a>
<p><br>
  First, database Manager program needs three files showing below:
</p>
<a href="Manual/screenshots/theFiles.png">
            <img alt="A screenshot showing all files of the program" src="Manual/screenshots/theFiles.png">
</a>
<ul>
            <li><b>DBmanager.jar</b> - the jar file runs the program</li>
            <li><b>MySQL.properties</b> - mainly contains your MySQL database user name and password</li>
            <li><b>RUN.bat</b> - windows user can double-click the file to run the program</li>
</ul>
<h4>MySQL.properties</h4>
        <p>It is simply a text file, you can open and edit in any editor. </p>
        <a href="Manual/screenshots/MySQLproperties.png">
            <img alt="A screenshot showing MySQL.properties" src="Manual/screenshots/MySQLproperties.png">
</a>
<ul>         
                <li><b><em>user:</em></b>
                root is the default user name in MySQL database<br></li> 
                <li><b><em>password:</em></b> As installing the MySQL database in your machine, they will ask you to set the password, then you can input your password in here.<br></li> 
                <li><b><em>dburl:</em></b> mysql://localhost:3306 is the default port once MySQL database being installed. No need to change that if not necessary.<br></li>
            </ul>
            <b>Note:</b> Do not leave space between the "=" sign.

<h2>Running the program</h2>
 <p>
            Double-click <b><em>RUN.bat</em></b>. After openning the program, click <b><em>initialize</em></b> to fetch all the schemas in your MySQL database. Select one then go into that one.
        </p>
 <a href="Manual/screenshots/initialize.gif" >
            <img src="Manual/screenshots/initialize.gif" alt="initialize the database gif" class="gif">
        </a>
        <p><b>As you entered your table panel, you will see the buttons below:</b></p>
        <a href="Manual/screenshots/functionBtn-table.png" >
            <img src="Manual/screenshots/functionBtn-table.png" alt="initialize the database gif">
        </a>
        <h4>Create new Table</h4>
        <a href="Manual/screenshots/createTableBtn.gif" >
            <img src="Manual/screenshots/createTableBtn.gif" alt="initialize the database gif" class="gif">
        </a>   
        <h4>Join</h4>
        <a href="Manual/screenshots/joinBtn.gif">
            <img src="Manual/screenshots/joinBtn.gif" alt="Join Bottom gif" class="gif">
        </a>
        <p>Join &rarr; Select the tables to be Joined &rarr; select columns to be shown in the join results &rarr; select join type &rarr; view the join results</p>
        <p><b>As you entered your data panel, you will see the buttons below:</b></p>
        <a href="Manual/screenshots/DataPanelBtns.png" >
            <img src="Manual/screenshots/DataPanelBtns.png" alt="dataPanel ScreenShot" class="southBtns">
        </a>
        <h4>Get Lat Lng</h4>
        <a href="Manual/screenshots/getLatLngBtn.png" >
            <img src="Manual/screenshots/getLatLngBtn.png" alt="Get Lat Lng Botton picture" class="pics">
        </a>
        <p><b><em>Get Lat Lng </em></b> enable you to retrieve the geometry information Latitute and Longitute from Google server. Select the corresponding <b>address</b> column then click <b>Ok</b>, it will take from few minutes or even longer based on your requests (rows) to google server.<br>
        Since google server does not accept client side constant requests to increse their server's load, 0.2 seconds interval was added between each requests, therefore it will take long time and please be patient to wait the whole results. </p>    
        <h4>Search</h4>
        <p>In the search panel, column names are autonatically fetched and you can do precise search by directly input the values on the form or range search using predicates.<br>
        <b>Note:</b> Please leave space between your predicates and values. Predicates supported includes:<br>
        </p>
        <ul>
            <li>&#x3C;</li>
            <li>&#x3E;</li>
            <li>&#x3C;=</li>
            <li>&#x3E;=</li>
            <li>&#x3C;&#x3E;</li>
            <li>!=</li>
            <li>LIKE</li>
            <li>NOT LIKE</li>
            <li>NOT</li>
            <p>Upper case and Lower case are both works.<br> 
                An examples are showing below:
            </p>      
        </ul>
        <a href="Manual/screenshots/SearchBtn.png">
            <img src="Manual/screenshots/SearchBtn.png" alt="Search Panel picture" class="pics2">
        </a>       
        <h4>Relationships</h4>
        <p>Pick the column that you want to be referenced like the example showing below:</p>   
        <a href="Manual/screenshots/relationshipBtn.png">
            <img src="Manual/screenshots/relationshipBtn.png" alt="relationship picture 1" class="pics3">
        </a>
        <p>After clicking <b><em>Finish</em></b>, you can go to the table that <em><b>was referenced</b></em>, click <b><em>Relationships</em></b> again, you can see the current table were referenced by whom, by which column, and what CONSTRAINT is.</p>
        <a href="Manual/screenshots/relationshipBtn2.png">
            <img src="Manual/screenshots/relationshipBtn2.png" alt="relationship picture 2" class="pics4">
        </a>
        <h4>Visualize</h4>
        <p>You can click the botton 
            <b><em>Visualize</em></b> in all data panel, could be search query results or join query results.<br>
            After clicking <b><em>Visualize</em></b> botton, Tableau decktop will pop up. 
        </p>
        <a href="Manual/screenshots/visualize1.png">
            <img src="Manual/screenshots/visualize1.png" alt="relationship picture 2" class="pics2">
        </a>
        <p>You need to connect mysql database using password.</p>
        <a href="Manual/screenshots/tableau1.gif">
            <img src="Manual/screenshots/tableau1.gif" alt="connect mysql to tableau gif" class="pics1">
        </a>
        <p>You can look up the table, or the query results from join or search. </p>
        <a href="Manual/screenshots/searchResultVis.png">
            <img src="Manual/screenshots/searchResultVis.png" alt="Search result example pic" class="pics5">
        </a>
        <p>Join and search queries' results are saved as view, which are also listing in the left side of tableau.</p>
        <a href="Manual/screenshots/searchResultVisTableauSide.png">
            <img src="Manual/screenshots/searchResultVisTableauSide.png" alt="Search result example pic at Tableau side" class="pics3">
        </a>      
        <h2>Running the Tableau Desktop</h2>
        <h4>Connect to the data source</h4>
        <p>Whenever you enter the tableau desktop software, the first page is to let you connect the data source. We use MySQL in our program settings, So select <b><em>MySQL</em></b>.</p>
        <a href="Manual/screenshots/TableauInstr0.png">
            <img src="Manual/screenshots/TableauInstr0.png" alt="Tableau connect source pic" class="pics3">
        </a>
        <p>In the log in panel, localhost, port 3306 and root are all the default settings unless you specifically connect to the database from another server of another machine.</p>
        <a href="Manual/screenshots/TableauInstr1.png">
            <img src="Manual/screenshots/TableauInstr1.png" alt="Tableau login pic" class="pics3">
        </a>
        <P>Choose the Database, then all tables of this database will be listed.</P>
        <a href="Manual/screenshots/TableauInstr1.png">
            <img src="Manual/screenshots/TableauInstr2.png" alt="Tableau login pic" class="pics3">
        </a>
        <h4>Plotting with your data</h4>
        <p><b>Step 1:</b>  
            use mouse to drag corresponding table into the blank space<br>
            <b>Step 2:</b> 
            Click <b><em>"Sheet1"</em></b> in the left-down corner to start a new canvas, you can also rename the sheet.<br>
            <b>Step 3:</b> Drag the corresponding columns into the <b>Columns</b> and <b>Rows</b>. e.g. drag Year into Columns, drag Value into Rows.
        </p>        
        <a href="Manual/screenshots/TableauInstr3.gif">
            <img src="Manual/screenshots/TableauInstr3.gif" alt="Tableau drag and plot example gif" class="gif">
        </a>
