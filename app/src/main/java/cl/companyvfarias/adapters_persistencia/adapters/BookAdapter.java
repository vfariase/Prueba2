package cl.companyvfarias.adapters_persistencia.adapters;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cl.companyvfarias.adapters_persistencia.BookClickListener;
import cl.companyvfarias.adapters_persistencia.R;
import cl.companyvfarias.adapters_persistencia.data.Queries;
import cl.companyvfarias.adapters_persistencia.models.Book;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {


    private List<Book> bookList= new Queries().books();
    private BookClickListener listener;

    public BookAdapter(BookClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        ViewHolder viewHolder =new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

         Book book= bookList.get(position);
         holder.textView.setText(String.valueOf(book.getIsbn()));
         holder.checkBox.setChecked(book.isAvailable());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            int auxPosition=holder.getAdapterPosition();
                            Book auxBook=bookList.get(auxPosition);
                            auxBook.setAvailable(true);
                            auxBook.save();
                            bookList.remove(auxPosition);
                            notifyItemRemoved(auxPosition);

                        }
                    },400);
                }
            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("onclick","dentro");
                Book auxBook = bookList.get(holder.getAdapterPosition());
                //listener.clickedID(auxBook.getId());
                listener.sendData(auxBook);
                listener.clickedID(auxBook.getId());
            }

        });


    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.bookCb);
            textView = itemView.findViewById(R.id.bookTv);


        }
    }


    public void updateList(Book book)
    {

        bookList.add(book);
        notifyDataSetChanged();
    }




}
