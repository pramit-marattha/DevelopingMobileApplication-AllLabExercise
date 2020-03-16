package np.com.pramitmarattha;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import np.com.pramitmarattha.QuizContract.*;

import java.util.ArrayList;
import java.util.List;


public class QuizDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "RapidQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private static QuizDatabase instance;

    private SQLiteDatabase db;

    private QuizDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized QuizDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new QuizDatabase(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " +
                CategoriesTable.TABLE_NAME + "( " +
                CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NUMBER + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                CategoriesTable.TABLE_NAME + "(" + CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
                ")";

        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillCategoriesTable();
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void fillCategoriesTable() {
        Category c1 = new Category("Python Question");
        insertCategory(c1);
        Category c2 = new Category("Java Question");
        insertCategory(c2);
        Category c3 = new Category("C# question");
        insertCategory(c3);
    }

    public void addCategory(Category category) {
        db = getWritableDatabase();
        insertCategory(category);
    }

    public void addCategories(List<Category> categories) {
        db = getWritableDatabase();

        for (Category category : categories) {
            insertCategory(category);
        }
    }

    private void insertCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(CategoriesTable.TABLE_NAME, null, cv);
    }

    private void fillQuestionsTable() {
        Questions q1 = new Questions("What is the value of this expression? 2**2**3**1",
                "256", "62", "Exception error raised", 1,
                Questions.DIFFICULTY_EASY, Category.PYTHON_CHALLENGE);
        insertQuestion(q1);
        Questions q2 = new Questions("How will you open a file for reading as a text file?",
                "open('file.txt')", "open('file.txt', w’)", "open('file.txt', z’)", 1,
                Questions.DIFFICULTY_MEDIUM, Category.PYTHON_CHALLENGE);
        insertQuestion(q2);
        Questions q3 = new Questions("Which of the following option leads to the portability and security of Java?",
                "The applet makes the Java code secure and portable", "Bytecode is executed by JVM", "Use of exception handling", 2,
                Questions.DIFFICULTY_HARD, Category.JAVA_CHALLENGE);
        insertQuestion(q3);
        Questions q4 = new Questions("Which of the following is not a Java features?",
                "Dynamic", "Use of pointers", "Architecture Neutral", 2,
                Questions.DIFFICULTY_EASY, Category.JAVA_CHALLENGE);
        insertQuestion(q4);
        Questions q5 = new Questions("We can use reserved keywords as identifiers in C# by prefixing them with @ character?",
                "true", "false", "I have no clue", 1,
                Questions.DIFFICULTY_EASY, Category.Csharp_CHALLENGE);
        insertQuestion(q5);
        Questions q6 = new Questions("Which of the following converts a type to a small floating point number in C#?",
                "ToSingle()", "ToInt64", "ToInt60", 1,
                Questions.DIFFICULTY_EASY, Category.Csharp_CHALLENGE);
        insertQuestion(q6);

///////////////////////////////////////////////////////////////////////////////////////////////////////////

        Questions q7 = new Questions("Which of the following function convert an integer to an unicode character in python?",
                "unichr(x)", "hex(x)", "hesx(x)", 1,
                Questions.DIFFICULTY_HARD, Category.PYTHON_CHALLENGE);
        insertQuestion(q7);
        Questions q8 = new Questions("What is the output of the following code?\n" +
                "\n" +
                "n =(m for m in range(3))\n" +
                "for m in n:\n" +
                "   print(m)\n" +
                "for m in n:\n" +
                "   print(m)",
                "0 1 2", "1 2 3", "0 1 2 3", 1,
                Questions.DIFFICULTY_HARD, Category.PYTHON_CHALLENGE);
        insertQuestion(q8);
        Questions q9 = new Questions("What of the following is the default value of an instance variable?",
                "null", "Depends upon the type of variable", "0", 2,
                Questions.DIFFICULTY_HARD, Category.JAVA_CHALLENGE);
        insertQuestion(q9);
        Questions q10 = new Questions("Inheritance represents",
                "HAS-A relationship.", "IS-A relationship.", "I dont know", 2,
                Questions.DIFFICULTY_HARD, Category.JAVA_CHALLENGE);
        insertQuestion(q10);
        Questions q11 = new Questions("Dynamic polymorphism is implemented by abstract classes and virtual functions.",
                "true", "false", "I have no clue", 1,
                Questions.DIFFICULTY_HARD, Category.Csharp_CHALLENGE);
        insertQuestion(q11);
        Questions q12 = new Questions("Which of the following preprocessor directive allows generating an error from a specific location in your code in C#?",
                "Define", "Region", "error", 3,
                Questions.DIFFICULTY_HARD, Category.Csharp_CHALLENGE);
        insertQuestion(q12);

///////////////////////////////////////////////////////////////////////////////////////////////////////////
        Questions q13 = new Questions("Which method is used to convert raw byte data to a string?",
                "Encode()", "Decode()", "Convert()", 2,
                Questions.DIFFICULTY_MEDIUM, Category.PYTHON_CHALLENGE);
        insertQuestion(q13);
        Questions q14 = new Questions("Which of the following function convert an object to a string in python?",
                "int(x [,base])", "str(x)", "open('file.txt', z’)", 2,
                Questions.DIFFICULTY_MEDIUM, Category.PYTHON_CHALLENGE);
        insertQuestion(q14);
        Questions q15 = new Questions("which operator is considered to be with highest precedence?",
                "()[] ", "--+", "No clue", 1,
                Questions.DIFFICULTY_MEDIUM, Category.JAVA_CHALLENGE);
        insertQuestion(q15);
        Questions q16 = new Questions("Can constructor be inherited?",
                "True", "False", "truse", 2,
                Questions.DIFFICULTY_MEDIUM, Category.JAVA_CHALLENGE);
        insertQuestion(q16);
        Questions q17 = new Questions("Which of the following access specifier in C# allows a class to hide its member variables and member functions from other functions and objects?",
                "private", "public", "I have no clue", 1,
                Questions.DIFFICULTY_MEDIUM, Category.Csharp_CHALLENGE);
        insertQuestion(q17);
        Questions q18 = new Questions("Which of the following operator returns the size of a data type in C#?",
                "sizeof", "typeof", "&</a>", 1,
                Questions.DIFFICULTY_MEDIUM, Category.Csharp_CHALLENGE);
        insertQuestion(q18);

///////////////////////////////////////////////////////////////////////////////////////////////////////////


    }

    public void addQuestion(Questions question) {
        db = getWritableDatabase();
        insertQuestion(question);
    }

    public void addQuestions(List<Questions> questions) {
        db = getWritableDatabase();

        for (Questions question : questions) {
            insertQuestion(question);
        }
    }

    private void insertQuestion(Questions question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NUMBER, question.getAnswerNumber());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuestionsTable.COLUMN_CATEGORY_ID, question.getCategoryID());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoriesTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Category category = new Category();
                category.setId(c.getInt(c.getColumnIndex(CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            } while (c.moveToNext());
        }

        c.close();
        return categoryList;
    }

    public ArrayList<Questions> getAllQuestions() {
        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNumber(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NUMBER)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Questions> getQuestions(int categoryID, String difficulty) {
        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = QuestionsTable.COLUMN_CATEGORY_ID + " = ? " +
                " AND " + QuestionsTable.COLUMN_DIFFICULTY + " = ? ";
        String[] selectionArgs = new String[]{String.valueOf(categoryID), difficulty};

        Cursor c = db.query(
                QuestionsTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (c.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNumber(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NUMBER)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}