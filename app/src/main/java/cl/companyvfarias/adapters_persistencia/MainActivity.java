package cl.companyvfarias.adapters_persistencia;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import cl.companyvfarias.adapters_persistencia.adapters.BookAdapter;
import cl.companyvfarias.adapters_persistencia.models.Book;

public class MainActivity extends AppCompatActivity {

    private BookFragment booksFragment;

    private FloatingActionButton fab;


//retrofit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        booksFragment = (BookFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        fab = findViewById(R.id.mainFab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog= new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_book);

                Button saveBtn=dialog.findViewById(R.id.saveBookIb);
                saveBtn.setOnClickListener(new View.OnClickListener() {

                    private String isbn;

                    @Override
                    public void onClick(View v) {
                        EditText input=dialog.findViewById(R.id.isbnEt);
                        EditText inputDescription=dialog.findViewById(R.id.descriptionEt);
                        isbn = input.getText().toString();

                        String description=inputDescription.getText().toString();

                        if( isbn.trim().length()> 0 && description.trim().length()>0)
                        {

                            Book book=new Book();
                            Toast.makeText(MainActivity.this, isbn +""+description, Toast.LENGTH_SHORT).show();
                            book.setIsbn(isbn);
                            book.setDescription(description);
                            book.setAvailable(false);
                            book.save();
                            Log.d("DB01", "base de datos: "+String.valueOf(book));
                            booksFragment.update(book);
                        } else {
                            Toast.makeText(MainActivity.this, "DEBE INGRESAR LOS DATOS REQUERIDOS", Toast.LENGTH_SHORT).show();}



                        dialog.dismiss();
                    }
                });

                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();

            }


        });


          }




}
