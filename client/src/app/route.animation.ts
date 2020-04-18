import { trigger, animate, transition, style, group, query } from '@angular/animations';

// Animating route transitions
//-1- Import  Browser Animations Module
//-2- Define the desired animations
//-3- Register the animtion with component
//-4- Trigger the animation from the router outlet

export const myAnimation = trigger('myAnimation', [
    // Transition between any two states
    transition('* <=> *', [
        // Events to apply
        // Defined style and animation function to apply
        // Config object with optional set to true to handle when element not yet added to the DOM
        query(':enter, :leave', style({ position: 'fixed', width: '100%', zIndex: 2 }), { optional: true }),
        // group block executes in parallel
        group([
            query(':enter', [
                style({ transform: 'translateX(100%)' }),
                animate('0.3s ease-out', style({ transform: 'translateX(0%)' }))
            ], { optional: true }),
            query(':leave', [
                style({ transform: 'translateX(0%)' }),
                animate('0.3s ease-out', style({ transform: 'translateX(-100%)' }))
            ], { optional: true })
        ])
    ])
])