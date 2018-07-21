package com.manning.gia.todo.repository;

import com.manning.gia.todo.model.ToDoItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class InMemoryToDoRepositoryTest {

    private ToDoRepository inMemoryToDoRepository;

    @Before
    public void setUp() {
        inMemoryToDoRepository = new InMemoryToDoRepository();
    }

    @Test
    public void insertTest() {
        ToDoItem newToDoItem = new ToDoItem();
        newToDoItem.setName("Write unit tests");

        Long newId = inMemoryToDoRepository.insert(newToDoItem);


        ToDoItem persistedTodo = inMemoryToDoRepository.findById(newId);
        assertNotNull(persistedTodo);
        assertEquals(newToDoItem, persistedTodo);
    }

}