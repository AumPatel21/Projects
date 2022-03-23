/**********************************************************************
Author: Aum Patel
Purpose: The purpose of this program is to reverse a linked list
***********************************************************************/

#include <stdio.h>
#include <stdlib.h>

struct node;
typedef struct node Node;

struct node
{
    int data;
    Node* next;
};

//Function declaration
void reverse_list(Node** head);

int main(int argc, char* argv[])
{
    Node* head = NULL;
    int i;
    Node* temp;

    //set up a test list with values 9->8->7->...->0
    for (i = 0; i < 10; i++)
    {
        temp = (Node*)malloc(sizeof(Node));
        if (temp == NULL)
        {
            printf("out of memory?\n");
            exit(1);
        }
        temp->data = i;
        temp->next = head;
        head = temp;
    }

    while (temp != NULL)
    {
        printf("%d", temp->data);
        temp = temp->next;
    }
    printf("\n");
    //call the function to reverse the list (should work for any list given the head node pointer).
    reverse_list(&head);

    //print the reversed list.
    temp = head;
    while (temp != NULL)
    {
        printf("%d", temp->data);
        temp = temp->next;
    }

    return 0;
}

//Function implementation
void reverse_list(Node** head)
{
    Node* prev_val = NULL;
    Node* curr_val = *head;
    Node* next_val = NULL;

    while(curr_val != NULL)
    {
        next_val = curr_val->next;
        curr_val->next = prev_val;
        prev_val = curr_val;
        curr_val = next_val;
    }
    *head = prev_val;
}