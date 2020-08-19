# Notes

Design process - separate concerns of pricing, basket and discounts.

Discount was implemented in a similar way to items in that they would be added to the basket during runtime.
However the limitation of this design currently is that it relies on a reference to each of the basket items to apply the discount correctly.
A simple enhancement to this would be to instead use product codes for items, where each code would represent a unique product.
That way discounts can be added seperately to the basket contents (or persisted via text file) and applied to the current basket independent of object references. 