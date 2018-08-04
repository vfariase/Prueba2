package cl.companyvfarias.adapters_persistencia;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.companyvfarias.adapters_persistencia.adapters.BookAdapter;
import cl.companyvfarias.adapters_persistencia.models.Book;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment implements BookClickListener {

    private RecyclerView mRecyclerView;
    private BookAdapter bookAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public BookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView=view.findViewById(R.id.bookRv);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        bookAdapter = new BookAdapter(this);
        mRecyclerView.setAdapter(bookAdapter);
    }


    public void update(Book book)
    {
      bookAdapter.updateList(book);
    }

    @Override
    public void clickedID(long id) {
        Toast.makeText(getContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendData(Book book) {
        Intent intent= new Intent(getContext(),DetailsBook.class);
        intent.putExtra("Book",book);
        startActivity(intent);

    }
}
