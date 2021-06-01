//
// Created by shazebs on 4/13/2021.
//

#ifndef PROJECT_1_STRINGLINK_H
#define PROJECT_1_STRINGLINK_H

#include <set>
#include <iostream>
using namespace std;


struct StringLink
{
    set<string> shipPins;
    StringLink *forward;
    StringLink *backward;

    StringLink *frontLink = nullptr;
    StringLink *backLink = nullptr;

    // Default Constructor.
    StringLink()
    {
        forward = nullptr;
        backward = nullptr;
    }
    // Destructor
    ~StringLink()
    {
        delete &shipPins;
        delete forward;
        delete backward;
    }

    // StringLink Operations.
    void pushback(StringLink *link)
    {
        if (!frontLink && !backLink)
        {
            frontLink = link;
        }
        else if (frontLink && !backLink)
        {
            frontLink->forward = link;
            link->backward = frontLink;
            backLink = link;
        }
        else if (frontLink && backLink)
        {
            backLink->forward = link;
            link->backward = backLink;
            backLink = link;
        }
    }
};

#endif //PROJECT_1_STRINGLINK_H
